package com.py.exception;

public class FileStorageException extends RuntimeException {


	private static final long serialVersionUID = 3623160797136162464L;

	public FileStorageException(String message) {
        super(message);
    }

    public FileStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
