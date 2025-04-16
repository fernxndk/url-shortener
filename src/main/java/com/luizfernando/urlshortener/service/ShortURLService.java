package com.luizfernando.urlshortener.service;

import com.luizfernando.urlshortener.model.ShortURL;
import com.luizfernando.urlshortener.repository.ShortURLRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShortURLService {

    private final ShortURLRepository repository;

    public ShortURLService(ShortURLRepository repository) {
        this.repository = repository;
    }

    public ShortURL saveUrl(String url) {
        ShortURL shortUrl = new ShortURL();
        shortUrl.setOriginalUrl(url);

        return repository.save(shortUrl);
    }

    public Optional<ShortURL> findById(String id) {
        return repository.findById(id);
    }
}
