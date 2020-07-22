package com.culinary.recipes.service;

import com.culinary.recipes.model.AllFacts;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class CatFactServiceImpl implements CatFactService {

    @Override
    public Mono<AllFacts> getCatFacts() {

        Mono<AllFacts> mono = WebClient.create()
                .get()
                .uri("https://cat-fact.herokuapp.com/facts")
                .retrieve().bodyToMono(AllFacts.class);
        return mono;
    }

    @Override
    public ResponseEntity<AllFacts> getCatFactsEntity() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity("https://cat-fact.herokuapp.com/facts", AllFacts.class);
    }
}
