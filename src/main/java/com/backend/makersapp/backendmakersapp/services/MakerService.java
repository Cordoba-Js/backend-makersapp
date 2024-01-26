package com.backend.makersapp.backendmakersapp.services;

import java.util.List;
import java.util.Optional;

import com.backend.makersapp.backendmakersapp.models.entities.Maker;

public interface MakerService {

    List<Maker> findAll();

    Optional<Maker> findById(Long id);

    Maker save(Maker maker);

    void remove(Long id);
}
