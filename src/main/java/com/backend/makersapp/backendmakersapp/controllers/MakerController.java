package com.backend.makersapp.backendmakersapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.makersapp.backendmakersapp.models.entities.Maker;
import com.backend.makersapp.backendmakersapp.services.MakerService;

@RestController
@RequestMapping("/makers")
@CrossOrigin(originPatterns = "*")
public class MakerController {

    @Autowired
    private MakerService makerService;

    @GetMapping
    public List<Maker> list() {
        return makerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMaker(@PathVariable Long id){

        Optional<Maker> makerOp = makerService.findById(id);
        if(makerOp.isPresent()){
            return ResponseEntity.ok(makerOp.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Maker maker){
        return ResponseEntity.status(HttpStatus.CREATED)
                    .body(makerService.save(maker));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Maker maker, @PathVariable Long id){
        
        Optional<Maker> makerOp = makerService.findById(id);
        if(makerOp.isPresent()) {
            Maker makerOld = makerOp.orElseThrow();
            makerOld.setName(maker.getName());
            makerOld.setLastName(maker.getLastName());
            makerOld.setEmail(maker.getEmail());

            return ResponseEntity.status(HttpStatus.CREATED)
                        .body(makerService.save(makerOld));

        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable Long id){

        Optional<Maker> makerOp = makerService.findById(id);
        if(makerOp.isPresent()) {
            makerService.remove(id);
            return ResponseEntity.noContent().build();
        }
        
        return ResponseEntity.notFound().build();
        
    }

}
