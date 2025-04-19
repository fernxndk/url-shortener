package com.luizfernando.urlshortener.service;

import com.luizfernando.urlshortener.model.ShortURL;
import com.luizfernando.urlshortener.repository.ShortURLRepository;
import com.luizfernando.urlshortener.utils.Base62IdGenerator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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
        shortUrl.setShortCode(Base62IdGenerator.generate(8));
        shortUrl.setExpirationDate(LocalDateTime.now().plusDays(7));

        return repository.save(shortUrl);
    }

    public Optional<ShortURL> findById(String id) {
        return repository.findById(id);
    }

    @Scheduled(fixedRate = 60000)
    @Transactional
    public void deleteExpiredUrls() {
        LocalDateTime now = LocalDateTime.now();
        repository.deleteByExpirationDateBefore(now);
    }
}
