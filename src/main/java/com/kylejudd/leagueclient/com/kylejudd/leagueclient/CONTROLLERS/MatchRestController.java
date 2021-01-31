package com.kylejudd.leagueclient.com.kylejudd.leagueclient.CONTROLLERS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@CrossOrigin
@RestController
@RequestMapping("/lol/match/v4/")
public class MatchRestController {

    private WebClient webClient;

    @Autowired
    public MatchRestController(WebClient webClient) {
        this.webClient = webClient;
    }

    @GetMapping("/matches/{matchId}/{apiKey}")
    p
}
