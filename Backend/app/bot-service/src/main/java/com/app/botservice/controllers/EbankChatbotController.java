package com.app.botservice.controllers;

import ma.enset.security.ebankbot.agents.EbankAiAgent;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EbankChatbotController {

    private EbankAiAgent ebankAiAgent;

    EbankChatbotController(EbankAiAgent ebankAiAgent) {
        this.ebankAiAgent = ebankAiAgent;
    }

    @GetMapping(value = "/chat" , produces = MediaType.TEXT_PLAIN_VALUE)
    public String chat(@RequestParam(name="query" , defaultValue = "Bonjour") Prompt query) {
       return ebankAiAgent.chat(query, "RestApi");
    }

}
