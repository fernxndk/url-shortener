package com.luizfernando.urlshortener.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "shortened_urls")
public class ShortURL {

    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private String shortCode;

    @Column
    private String originalUrl;

    @Column
    private LocalDateTime expirationDate;

    public ShortURL() {
    }

    public ShortURL(String shortCode, String originalUrl, LocalDateTime expirationDate) {
        this.shortCode = shortCode;
        this.originalUrl = originalUrl;
        this.expirationDate = expirationDate;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }
}
