package com.kylejudd.leagueclient.com.kylejudd.leagueclient.CONTROLLERS;

import com.kylejudd.leagueclient.com.kylejudd.leagueclient.DTO.LeagueAccount;
import com.kylejudd.leagueclient.com.kylejudd.leagueclient.DTO.MatchList;
import com.kylejudd.leagueclient.com.kylejudd.leagueclient.DTO.MatchReference;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.logging.Logger;

@CrossOrigin
@RestController
public class LeagueAccountController {

    private final static Logger LOGGER = Logger.getLogger(LeagueAccountController.class.getName());
    private RestTemplate restTemplate;

    @Autowired
    public LeagueAccountController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/leagueAccount/{summonerName}")
    public LeagueAccount getLeagueAccount(@PathVariable String summonerName) {
        String endpointUrl = "https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + summonerName + "?api_key=RGAPI-808772e5-79b7-45ce-8e61-c3f93df9a0e9";
        LeagueAccount leagueAccount = restTemplate.getForObject(endpointUrl, LeagueAccount.class);
        return leagueAccount;
    }

    @GetMapping("/matches/{accountId}")
    public MatchList getMatches(@PathVariable String accountId) {
        String endpointUrl = "https://na1.api.riotgames.com/lol/match/v4/matchlists/by-account/" + accountId + "?api_key=RGAPI-808772e5-79b7-45ce-8e61-c3f93df9a0e9";
        MatchList matchList = restTemplate.getForObject(endpointUrl, MatchList.class);
        return matchList;
    }
}
