package com.backend.makersapp.backendmakersapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.makersapp.backendmakersapp.models.entities.Maker;
import com.backend.makersapp.backendmakersapp.services.MakerService;
import com.backend.makersapp.backendmakersapp.services.rest.dto.Embedded;
import com.backend.makersapp.backendmakersapp.services.rest.dto.RootRequest;

@RestController
@RequestMapping("/rest")
public class EmbeddedRestController {

    @Autowired
    private MakerService makerService;

    @PostMapping("/process-json")
    public ResponseEntity<?> processJson(@RequestBody RootRequest rootRequest) {
        
        Embedded embedded = rootRequest.get_embedded();

        embedded.getStudents().forEach( s -> {

            Maker maker = new Maker();

            maker.setName(s.getFirstname());
            maker.setLastName(s.getLastname());
            maker.setEmail(s.getEmail());

            makerService.save(maker);
        });

        return ResponseEntity.ok().build();
    }
        

}
