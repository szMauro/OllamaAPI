package com.ollama_api.exceptions;

public class ModelResponseException extends RuntimeException {
    public ModelResponseException(String message) {
        super(message);
    }
}
