package com.kylejudd.leagueclient.com.kylejudd.leagueclient.CONTROLLERS;

import com.kylejudd.leagueclient.com.kylejudd.leagueclient.DTO.SummonerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@CrossOrigin
@RestController
@RequestMapping("/lol/summoner/v4/summoners/")
public class SummonerRestController {
    ;
    private WebClient webClient;

    @Autowired
    public SummonerRestController(WebClient webClient) {
        this.webClient = webClient;
    }

    @GetMapping("/by-name/{summonerName}/{apiKey}")
    public Mono<ResponseEntity<SummonerDTO>> getSummonerBySummonerName(@PathVariable String summonerName, @PathVariable String apiKey) {
        final String URI = "https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + summonerName + "?api_key=" + apiKey;
        return webClient.get().uri(URI).retrieve().toEntity(SummonerDTO.class);
    }

    @GetMapping("/by-account/{encryptedAccountId}/{apiKey}")
    public Mono<ResponseEntity<SummonerDTO>> getSummonerByAccountId(@PathVariable String accountId, @PathVariable String apiKey) {
        final String URI = "https://na1.api.riotgames.com/lol/match/v4/matchlists/by-account/" + accountId + "?api_key=" + apiKey;
        return webClient.get().uri(URI).retrieve().toEntity(SummonerDTO.class);
    }

    @GetMapping("/by-puuid/{encryptedPUUID}/{apiKey}")
    public Mono<ResponseEntity<SummonerDTO>> getSummonerByPUUID(@PathVariable String puuid, @PathVariable String apiKey) {
        final String URI = "https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-puuid/" + puuid + "?api_key=" + apiKey;
        return webClient.get().uri(URI).retrieve().toEntity(SummonerDTO.class);
    }

    @GetMapping("/{encryptedSummonerId}/{apiKey}")
    public Mono<ResponseEntity<SummonerDTO>> getSummonerBySummonerID(@PathVariable String summonerId, @PathVariable String apiKey) {
        final String URI = "https://na1.api.riotgames.com/lol/summoner/v4/summoners/" + summonerId + "?api_key=" + apiKey;
        return webClient.get().uri(URI).retrieve().toEntity(SummonerDTO.class);
    }
}
