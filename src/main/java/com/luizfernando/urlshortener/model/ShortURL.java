package com.luizfernando.urlshortener.model;

import com.luizfernando.urlshortener.utils.Base62IdGenerator;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "shortened_urls")
public class ShortURL {

    @Id
    private String shortCode;

    @Column
    private String originalUrl;

    @Column
    private LocalDateTime expirationDate;

    @PrePersist
    public void generateId() {
        this.shortCode = Base62IdGenerator.generate(8);
    }

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
