package com.luizfernando.urlshortener.repository;

import com.luizfernando.urlshortener.model.ShortURL;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ShortURLRepository extends JpaRepository<ShortURL, String> {

    void deleteByExpirationDateBefore(LocalDateTime now);
}
