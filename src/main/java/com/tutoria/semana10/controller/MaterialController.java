package com.tutoria.semana10.controller;

import com.tutoria.semana10.entities.MaterialEntity;
import com.tutoria.semana10.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materiais")
public class MaterialController {

    private final MaterialService materialService;

    @Autowired
    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping
    public ResponseEntity<List<MaterialEntity>> getAllMaterials() {
        List<MaterialEntity> materiais = materialService.findAll();
        return ResponseEntity.ok(materiais);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaterialEntity> getMaterialById(@PathVariable Long id) {
        MaterialEntity material = materialService.findById(id);
        return ResponseEntity.ok(material);
    }

    @PostMapping
    public ResponseEntity<MaterialEntity> createMaterial(@RequestBody MaterialEntity material) {
        MaterialEntity savedMaterial = materialService.save(material);
        return new ResponseEntity<>(savedMaterial, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MaterialEntity> updateMaterial(@PathVariable Long id, @RequestBody MaterialEntity materialDetails) {
        MaterialEntity updatedMaterial = materialService.update(id, materialDetails);
        return ResponseEntity.ok(updatedMaterial);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaterial(@PathVariable Long id) {
        materialService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

