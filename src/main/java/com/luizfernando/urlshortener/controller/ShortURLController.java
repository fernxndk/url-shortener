package com.luizfernando.urlshortener.controller;

import com.luizfernando.urlshortener.model.ShortURL;
import com.luizfernando.urlshortener.service.ShortURLService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
public class ShortURLController {

    private final ShortURLService service;

    public ShortURLController(ShortURLService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<ShortURL> shortenUrl(@RequestBody Map<String, String> body) {
        String originalUrl = body.get("url");

        ShortURL save = service.saveUrl(originalUrl);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShortURL> redirect(@PathVariable String id) {
        Optional<ShortURL> shortUrl = service.findById(id);

        if (shortUrl.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.FOUND).header("Location", shortUrl.get().getOriginalUrl()).build();
    }
}