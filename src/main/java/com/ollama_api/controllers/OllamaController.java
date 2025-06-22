package com.ollama_api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ollama_api.dto.PromptRequest;
import com.ollama_api.dto.PromptResponse;
import com.ollama_api.services.LlamaAiService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class OllamaController {
    private final LlamaAiService llamaAiService;

    public OllamaController(LlamaAiService llamaAiService) {
        this.llamaAiService = llamaAiService;
    }

    @PostMapping("/generate")
    public ResponseEntity<?> generateResponse(@Valid @RequestBody PromptRequest request,
            @RequestParam(value = "raw", defaultValue = "false") boolean raw) {
        PromptResponse response = llamaAiService.generateResult(request);

        if (raw) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.ok(response.getResponse());
    }
}
