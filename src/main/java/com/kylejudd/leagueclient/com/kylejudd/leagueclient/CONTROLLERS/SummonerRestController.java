package com.kylejudd.leagueclient.com.kylejudd.leagueclient.CONTROLLERS;

import com.kylejudd.leagueclient.com.kylejudd.leagueclient.DTO.SummonerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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
    private final String API_KEY;
    private Environment env;

    @Autowired
    public SummonerRestController(WebClient webClient, Environment env) {
        this.webClient = webClient;
        this.env = env;
        this.API_KEY = env.getProperty("API_KEY");
    }

    @GetMapping("by-name/{summonerName}")
    public Mono<ResponseEntity<SummonerDTO>> getSummonerBySummonerName(@PathVariable String summonerName) {
        final String URI = "https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + summonerName + "?api_key=" + API_KEY;
        return webClient.get().uri(URI).retrieve().toEntity(SummonerDTO.class);
    }

    @GetMapping("by-account/{encryptedAccountId}/{apiKey}")
    public Mono<ResponseEntity<SummonerDTO>> getSummonerByAccountId(@PathVariable String accountId) {
        final String URI = "https://na1.api.riotgames.com/lol/match/v4/matchlists/by-account/" + accountId + "?api_key=" + API_KEY;
        return webClient.get().uri(URI).retrieve().toEntity(SummonerDTO.class);
    }

    @GetMapping("by-puuid/{encryptedPUUID}/{apiKey}")
    public Mono<ResponseEntity<SummonerDTO>> getSummonerByPUUID(@PathVariable String puuid) {
        final String URI = "https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-puuid/" + puuid + "?api_key=" + API_KEY;
        return webClient.get().uri(URI).retrieve().toEntity(SummonerDTO.class);
    }

    @GetMapping("{encryptedSummonerId}/{apiKey}")
    public Mono<ResponseEntity<SummonerDTO>> getSummonerBySummonerID(@PathVariable String summonerId) {
        final String URI = "https://na1.api.riotgames.com/lol/summoner/v4/summoners/" + summonerId + "?api_key=" + API_KEY;
        return webClient.get().uri(URI).retrieve().toEntity(SummonerDTO.class);
    }
}
