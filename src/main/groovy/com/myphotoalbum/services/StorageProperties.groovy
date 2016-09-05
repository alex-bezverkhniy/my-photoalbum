package com.myphotoalbum.services

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("storage")
public class StorageProperties {
	
	private String location = "upload-dir"

}
