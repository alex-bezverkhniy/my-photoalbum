package com.myphotoalbum.services

class StorageFileNotFoundException extends StorageException {

	public StorageFileNotFoundException(String message, Throwable cause) {
		super(message, cause)
	}

	public StorageFileNotFoundException(String message) {
		super(message)
	}

	public StorageFileNotFoundException(Throwable cause) {
		super(cause)
	}
	
}
