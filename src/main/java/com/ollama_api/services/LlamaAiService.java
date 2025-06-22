package com.ollama_api.services;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ollama_api.dto.PromptRequest;
import com.ollama_api.dto.PromptResponse;
import com.ollama_api.exceptions.ModelResponseException;

@Service
public class LlamaAiService {

    private final String modelName;
    private final OllamaChatModel chatModel;

    public LlamaAiService(OllamaChatModel chatModel, @Value("${ollama.model}") String modelName) {
        this.chatModel = chatModel;
        this.modelName = modelName;
    }

    public PromptResponse generateResult(PromptRequest prompt) {
        OllamaOptions options = new OllamaOptions();
        options.setModel(modelName);

        ChatResponse response = chatModel.call(new Prompt(prompt.getPromptMessage(), options));
        if (response != null) {
            PromptResponse promptResponse = new PromptResponse();
            promptResponse.setResponse(response.getResult().getOutput().getText());
            return promptResponse;
        }
        throw new ModelResponseException("No response from model");
    }
}
