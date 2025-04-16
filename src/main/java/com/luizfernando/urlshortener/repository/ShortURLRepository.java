package com.luizfernando.urlshortener.repository;

import com.luizfernando.urlshortener.model.ShortURL;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShortURLRepository extends JpaRepository<ShortURL, String> {

}
