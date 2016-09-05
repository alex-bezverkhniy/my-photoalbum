package com.myphotoalbum

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean

import com.myphotoalbum.services.FileSystemStorageService
import com.myphotoalbum.services.StorageProperties

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
class MyPhotoalbumApplication {

	static void main(String[] args) {
		SpringApplication.run MyPhotoalbumApplication, args
	}
	
	@Bean
	CommandLineRunner init(FileSystemStorageService storageService) {
		return  {
            storageService.init()
		};
	}
}
