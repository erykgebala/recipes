package com.culinary.recipes.service;

import com.culinary.recipes.model.AllFacts;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

public interface CatFactService {

    Mono<AllFacts> getCatFacts();
    ResponseEntity<AllFacts> getCatFactsEntity();
}
