package com.kylejudd.leagueclient.com.kylejudd.leagueclient.CONTROLLERS;

import com.kylejudd.leagueclient.com.kylejudd.leagueclient.DTO.AccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


import java.util.logging.Logger;

@RestController
@RequestMapping("/riot/account/v1")
public class AccountRestController {

    private WebClient webClient;

    @Autowired
    public AccountRestController(WebClient webClient) {
        this.webClient = webClient;
    }

    @GetMapping("/accounts/by-puuid/{puuid}/{apiKey}")
    public Mono<ResponseEntity<AccountDTO>> getAccountByPuuid(@PathVariable String puuid, @PathVariable String apiKey) {
        final String URI = "https://americas.api.riotgames.com/riot/account/v1/accounts/by-puuid/" + puuid + "?api_key=" + apiKey;
        return webClient.get().uri(URI).retrieve().toEntity(AccountDTO.class);
    }

    @GetMapping("/accounts/by-riot-id/{gameName}/{tagLine}/{apiKey}")
    public Mono<ResponseEntity<AccountDTO>> getAccountByGameNameAndTagline(@PathVariable String gameName, @PathVariable String tagLine, @PathVariable String apiKey) {
        final String URI = "https://americas.api.riotgames.com/riot/account/v1/accounts/by-riot-id/" + gameName + "/" + tagLine + "?api_key=" + apiKey;
        return webClient.get().uri(URI).retrieve().toEntity(AccountDTO.class);
    }
}
