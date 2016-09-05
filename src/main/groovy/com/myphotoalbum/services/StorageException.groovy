package com.myphotoalbum.services

class StorageException extends RuntimeException {

	public StorageException(String message, Throwable cause) {
		super(message, cause)
	}

	public StorageException(String message) {
		super(message)
	}

	public StorageException(Throwable cause) {
		super(cause)
	}
	
}
