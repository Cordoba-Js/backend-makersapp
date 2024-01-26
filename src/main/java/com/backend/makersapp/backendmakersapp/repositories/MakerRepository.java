package com.backend.makersapp.backendmakersapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.makersapp.backendmakersapp.models.entities.Maker;

public interface MakerRepository extends JpaRepository <Maker, Long>{

}
