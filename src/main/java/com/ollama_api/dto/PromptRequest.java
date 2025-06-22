package com.ollama_api.dto;

import jakarta.validation.constraints.NotBlank;

public class PromptRequest {
    @NotBlank(message = "Prompt message cannot be empty")
    private String promptMessage;

    public String getPromptMessage() {
        return promptMessage;
    }

    public void setPromptMessage(String promptMessage) {
        this.promptMessage = promptMessage;
    }
}
