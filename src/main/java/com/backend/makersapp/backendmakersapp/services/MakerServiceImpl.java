package com.backend.makersapp.backendmakersapp.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.makersapp.backendmakersapp.models.entities.Maker;
import com.backend.makersapp.backendmakersapp.repositories.MakerRepository;

import jakarta.annotation.Nonnull;

@Service
public class MakerServiceImpl implements MakerService {

    @Autowired
    private MakerRepository makerRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Maker> findAll() {
        return makerRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Maker> findById(Long id) {
        @Nonnull Long idNonNull = Objects.requireNonNull(id);
        return makerRepository.findById(idNonNull);
    }

    @Override
    @Transactional
    public Maker save(Maker maker) {
        @Nonnull Maker makerNonNull = Objects.requireNonNull(maker);
        return makerRepository.save(makerNonNull);
    }

    @Override
    @Transactional
    public void remove(Long id) {
        @Nonnull Long idNonNull = Objects.requireNonNull(id);
        makerRepository.deleteById(idNonNull);
    }

}
