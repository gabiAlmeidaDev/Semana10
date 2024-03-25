package com.tutoria.semana10.controller;

import com.tutoria.semana10.entities.TutorEntity;
import com.tutoria.semana10.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutores")
public class TutorController {

    private final TutorService tutorService;

    @Autowired
    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @GetMapping
    public ResponseEntity<List<TutorEntity>> getAllTutores() {
        List<TutorEntity> tutores = tutorService.findAll();
        return ResponseEntity.ok(tutores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TutorEntity> getTutorById(@PathVariable Long id) {
        TutorEntity tutor = tutorService.findById(id);
        return ResponseEntity.ok(tutor);
    }

    @PostMapping
    public ResponseEntity<TutorEntity> createTutor(@RequestBody TutorEntity tutor) {
        TutorEntity savedTutor = tutorService.save(tutor);
        return new ResponseEntity<>(savedTutor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TutorEntity> updateTutor(@PathVariable Long id, @RequestBody TutorEntity tutorDetails) {
        TutorEntity updatedTutor = tutorService.update(id, tutorDetails);
        return ResponseEntity.ok(updatedTutor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTutor(@PathVariable Long id) {
        tutorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
