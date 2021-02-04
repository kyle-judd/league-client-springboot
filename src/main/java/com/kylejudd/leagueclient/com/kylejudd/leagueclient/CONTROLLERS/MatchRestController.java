package com.kylejudd.leagueclient.com.kylejudd.leagueclient.CONTROLLERS;

import com.kylejudd.leagueclient.com.kylejudd.leagueclient.DTO.MatchDTO;
import com.kylejudd.leagueclient.com.kylejudd.leagueclient.DTO.MatchTimelineDTO;
import com.kylejudd.leagueclient.com.kylejudd.leagueclient.DTO.MatchlistDTO;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/lol/match/v4")
public class MatchRestController {

    private Environment env;
    private final String API_KEY;
    private WebClient webClient;

    @Autowired
    public MatchRestController(WebClient webClient, Environment env) {
        this.webClient = webClient;
        this.env = env;
        API_KEY = env.getProperty("API_KEY");
    }

    @GetMapping("/matches/{matchId}")
    public Mono<ResponseEntity<MatchDTO>> getMatchesByMatchId(@PathVariable long matchId) {
        final String URI = "https://na1.api.riotgames.com/lol/match/v4/matches/" + matchId + "?api_key=" + API_KEY;
        return webClient.get().uri(URI).retrieve().toEntity(MatchDTO.class);
    }

    @GetMapping("/matchlists/by-account/{encryptedAccountId}")
    public Mono<ResponseEntity<MatchlistDTO>> getMatchlistByAccountId(@PathVariable String encryptedAccountId,
                                                                      @RequestParam(value = "champion") Optional<Set<Integer>> champions,
                                                                      @RequestParam(value = "queue") Optional<Set<Integer>> queues,
                                                                      @RequestParam Optional<Long> beginTime,
                                                                      @RequestParam Optional<Long> endTime,
                                                                      @RequestParam Optional<Integer> beginIndex,
                                                                      @RequestParam Optional<Integer> endIndex,
                                                                      UriComponentsBuilder builder) {
        UriComponents components = builder
                .scheme("https")
                .host("na1.api.riotgames.com")
                .path("/lol/match/v4/matchlists/by-account/{accountId}").port(-1)
                .queryParamIfPresent("champion", champions)
                .queryParamIfPresent("queue", queues)
                .queryParamIfPresent("beginTime", beginTime)
                .queryParamIfPresent("endTime", endTime)
                .queryParamIfPresent("beginIndex", beginIndex)
                .queryParamIfPresent("endIndex", endIndex)
                .queryParam("api_key", API_KEY).buildAndExpand(encryptedAccountId);


        return webClient.get().uri(components.toUri()).retrieve().toEntity(MatchlistDTO.class);
    }

    @GetMapping("/timelines/by-match/{matchId}")
    public Mono<ResponseEntity<MatchTimelineDTO>> getTimelineByMatchId(@PathVariable long matchId) {
        final String URI = "https://na1.api.riotgames.com/lol/match/v4/timelines/by-match/" + matchId + "?api_key=" + API_KEY;
        return webClient.get().uri(URI).retrieve().toEntity(MatchTimelineDTO.class);
    }

}
