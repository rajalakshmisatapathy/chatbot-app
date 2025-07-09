package com.chatboot.ai_chatbot.controller;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ChatController {
    private final ChatClient chatClient;

    @Autowired
    public ChatController(OllamaChatModel chatModel) {
        this.chatClient = ChatClient.create(chatModel);
    }

    @GetMapping("/{message}")
    public ResponseEntity<String> getAnswer(@PathVariable String message) {

        String response = chatClient.prompt(message).call().content();
        System.out.println("Response ::" +response.replaceAll("(?is)<think>.*?</think>", "").trim());
        return ResponseEntity.ok(response.replaceAll("(?is)<think>.*?</think>", "").trim());
    }

}

