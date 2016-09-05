package com.myphotoalbum.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.Resource
import org.springframework.core.io.UrlResource
import org.springframework.util.FileSystemUtils
import org.springframework.web.multipart.MultipartFile
import org.springframework.stereotype.Service

import java.nio.file.Path
import java.nio.file.Files
import java.nio.file.Paths
import java.util.stream.Stream

@Service
class FileSystemStorageService {

	private final Path rootLocation

	@Autowired
	public FileSystemStorageService(StorageProperties properties) {
		rootLocation = Paths.get(properties.location)
	}

	public void init(){
		try {
			if (!Files.exists(rootLocation) || !Files.isDirectory(rootLocation)) {
				Files.createDirectory(rootLocation)
			}
		} catch(IOException ex) {
		throw new StorageException("Could not initialize storage", ex)
		}
	}

	public void store(List<MultipartFile> files) {
		try {
			if (files == null || files.isEmpty()) {
				throw new StorageException("Filed to store empty files list")
			}
			for(MultipartFile file in files) {
				Files.copy(file.inputStream, rootLocation.resolve(file.originalFilename))
			}
		} catch(IOException ex) {
			throw new StorageException("Filed to store files", ex)
		}
	}

	public List<Path> loadAll(){
		List<Path> result = []
		
		try {
			result = Files.newDirectoryStream(rootLocation).collect()
			/*
			result = Files.walk(rootLocation, 1)
			.findAll {Path path -> path.equals(rootLocation)}
			.collect {Path path -> rootLocation.relativize(path)}
			*/
			
		} catch(IOException ex) {
			throw new StorageException("Filed to read storied files", ex)
		}
		return result
	}

	public Path load(String filename){
		return rootLocation.resolve(filename)
	}

	public Resource loadAsResource(String filename){
		try {
		Path file = load(filename)
		Resource resource = new UrlResource(file.toUri())
		
		if (resource.exists() || resource.isReadable()) {
			return resource
		} else {
			throw new StorageFileNotFoundException("Could not read file ${filename}")
		}
		} catch(MalformedURLException ex) {
			throw new StorageFileNotFoundException("Could not read file ${filename}", ex)
		}
		
	}

	public void deleteAll(){
		FileSystemUtils.deleteRecursively(rootLocation.toFile())
	}
}
