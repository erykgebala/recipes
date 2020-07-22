package com.culinary.recipes.controller;

import com.culinary.recipes.model.AllFacts;
import com.culinary.recipes.service.CatFactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class CatController {

    private CatFactService catFactService;

    @Autowired
    public CatController(CatFactService catFactService) {
        this.catFactService = catFactService;
    }

    @GetMapping("/facts")
    public ResponseEntity<AllFacts> getCatFactEntity() {
        return this.catFactService.getCatFactsEntity();
    }

    @GetMapping("/factsmono")
    public Mono<AllFacts> getCatFact() {
        return this.catFactService.getCatFacts();
    }
}
