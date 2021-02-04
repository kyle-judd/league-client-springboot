package com.kylejudd.leagueclient.com.kylejudd.leagueclient.CONTROLLERS;

import com.kylejudd.leagueclient.com.kylejudd.leagueclient.DTO.LeagueEntryDTO;
import com.kylejudd.leagueclient.com.kylejudd.leagueclient.DTO.LeagueListDTO;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/lol/league/v4")
public class LeagueRestController {

    private WebClient webClient;
    private final String API_KEY;
    private Environment env;

    @Autowired
    public LeagueRestController(WebClient webClient, Environment env) {
        this.webClient = webClient;
        this.env = env;
        this.API_KEY = env.getProperty("API_KEY");
    }

    @GetMapping("/challengerLeagues/by-queue/{queue}")
    public Mono<ResponseEntity<LeagueListDTO>> getChallengerLeaguesByQueue(@PathVariable String queue) {
        final String URI = "https://na1.api.riotgames.com/lol/league/v4/challengerleagues/by-queue/" + queue + "?api_key=" + API_KEY;
        return webClient.get().uri(URI).retrieve().toEntity(LeagueListDTO.class);
    }

    @GetMapping("/entries/by-summoner/{encryptedSummonerId}")
    public Mono<ResponseEntity<LeagueEntryDTO>> getLeagueEntriesByEncryptedSummonerId(@PathVariable String summonerId) {
        final String URI = "https://na1.api.riotgames.com/lol/league/v4/entries/by-summoner/" + summonerId + "?api_key=" + API_KEY;
        return webClient.get().uri(URI).retrieve().toEntity(LeagueEntryDTO.class);
    }

    @GetMapping("/entries/{queue}/{tier}/{division}")
    public Mono<ResponseEntity<List<LeagueEntryDTO>>> getAllLeagueEntries(@PathVariable String queue,
                                                                          @PathVariable String tier,
                                                                          @PathVariable String division,
                                                                          @RequestParam Optional<Integer> page,
                                                                          UriComponentsBuilder builder) {
        Map<String, String> params = new HashMap<>();
        params.put("queue", queue);
        params.put("tier", tier);
        params.put("division", division);

        UriComponents components = builder.scheme("https")
                .host("na1.api.riotgames.com")
                .path("/lol/league/v4/entries/{queue}/{tier}/{division}")
                .port(-1)
                .queryParamIfPresent("page", page)
                .queryParam("api_key", API_KEY)
                .buildAndExpand(params);
        System.out.println(components.toString());
        return webClient.get().uri(components.toUri()).retrieve().toEntityList(LeagueEntryDTO.class);
    }

    @GetMapping("/grandmasterLeagues/by-queue/{queue}")
    public Mono<ResponseEntity<LeagueListDTO>> getGrandmasterLeagueByQueue(@PathVariable String queue) {
        final String URI = "https://na1.api.riotgames.com/lol/league/v4/grandmasterleagues/by-queue/" + queue + "?api_key=" + API_KEY;
        return webClient.get().uri(URI).retrieve().toEntity(LeagueListDTO.class);
    }

    @GetMapping("/leagues/{leagueId}")
    public Mono<ResponseEntity<LeagueListDTO>> getLeagueByLeagueId(@PathVariable String leagueId) {
        final String URI = "https://na1.api.riotgames.com/lol/league/v4/leagues/" + leagueId + "?api_key=" + API_KEY;
        return webClient.get().uri(URI).retrieve().toEntity(LeagueListDTO.class);
    }

    @GetMapping("/masterLeagues/by-queue/{queue}")
    public Mono<ResponseEntity<LeagueListDTO>> getMasterLeagueByQueue(@PathVariable String queue) {
        final String URI = "https://na1.api.riotgames.com/lol/league/v4/masterleagues/by-queue/" + queue + "?api_key=" + API_KEY;
        return webClient.get().uri(URI).retrieve().toEntity(LeagueListDTO.class);
    }
}
