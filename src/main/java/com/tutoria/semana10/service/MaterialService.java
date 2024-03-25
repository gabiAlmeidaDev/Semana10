package com.tutoria.semana10.service;

import com.tutoria.semana10.entities.MaterialEntity;
import com.tutoria.semana10.error.MaterialNotFoundException;
import com.tutoria.semana10.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {

    private final MaterialRepository materialRepository;

    @Autowired
    public MaterialService(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    public List<MaterialEntity> findAll() {
        return materialRepository.findAll();
    }

    public MaterialEntity findById(Long id) {
        return materialRepository.findById(id)
                .orElseThrow(() -> new MaterialNotFoundException(id));
    }

    public MaterialEntity save(MaterialEntity material) {
        return materialRepository.save(material);
    }

    public MaterialEntity update(Long id, MaterialEntity materialDetails) {
        MaterialEntity material = findById(id);
        material.setAgenda(materialDetails.getAgenda());
        material.setDescricao(materialDetails.getDescricao());
        material.setCaminhoArquivo(materialDetails.getCaminhoArquivo());
        return materialRepository.save(material);
    }

    public void deleteById(Long id) {
        MaterialEntity material = findById(id);
        materialRepository.delete(material);
    }
}

