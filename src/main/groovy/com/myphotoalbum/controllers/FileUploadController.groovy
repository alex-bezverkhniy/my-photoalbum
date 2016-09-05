package com.myphotoalbum.controllers

import java.lang.reflect.Method
import java.nio.file.Path

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.Resource
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder
import org.springframework.web.servlet.mvc.support.RedirectAttributes

import com.myphotoalbum.services.FileSystemStorageService
import com.myphotoalbum.services.StorageFileNotFoundException

@Controller
class FileUploadController {

	@Autowired
	FileSystemStorageService storageService
	
	@Value("{application.message:Hello World}")
	private String message = "Hello World"
	
	@GetMapping("/")
	public String listUploadedFiles(Model model) {
		/*
		model.addAttribute("files", storageService
			.loadAll()
			.collect {Path path -> 
				path.fileName.toString()
				//MvcUriComponentsBuilder.fromMethod(FileUploadController.class, "serveFile", path.fileName.toString()).build().toString()
			}
		)	
		*/
		Method m = FileUploadController.class.methods.find {Method m -> m.name == "serveFile"}
		model.addAttribute("files", storageService.loadAll().collect {Path p ->
			String url = MvcUriComponentsBuilder.fromMethod(FileUploadController.class, m, p.fileName.toString()).build().toString()
			String title = p.fileName.toString()
			return [url: url, title: title]
		})
		return "uploadForm"
	} 	
	
	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

		Resource file = storageService.loadAsResource(filename)
		return ResponseEntity
				.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment filename=\""+file.getFilename()+"\"")
				.body(file)
	}

	@PostMapping("/")
	public String handleFileUpload(@RequestParam("file") List<MultipartFile> files,
								   RedirectAttributes redirectAttributes) {

		storageService.store(files)
		redirectAttributes.addFlashAttribute("message",
				"You successfully uploaded " + files.collect { MultipartFile f -> f.getOriginalFilename()}.join(', ') + "!")

		return "redirect:/"
	}

	@ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity handleStorageFileNotFound(StorageFileNotFoundException exc) {
		return ResponseEntity.notFound().build()
	}
}
