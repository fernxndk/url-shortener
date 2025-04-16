package com.luizfernando.urlshortener.controller;

import com.luizfernando.urlshortener.model.ShortURL;
import com.luizfernando.urlshortener.service.ShortURLService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ShortURLController {

    private final ShortURLService service;

    public ShortURLController (ShortURLService service) {
        this.service = service;
    }

    @PostMapping("/shorten")
    public ResponseEntity<ShortURL> shortenUrl(@RequestBody Map<String, String> body) {
        String originalUrl = body.get("url");

        ShortURL save = service.saveUrl(originalUrl);
        return ResponseEntity.ok(save);
    }

}
