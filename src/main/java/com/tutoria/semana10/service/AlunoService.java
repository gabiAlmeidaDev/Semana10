package com.tutoria.semana10.service;

import com.tutoria.semana10.entities.AlunoEntity;
import com.tutoria.semana10.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    @Autowired
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<AlunoEntity> findAll() {
        return alunoRepository.findAll();
    }

    public Optional<AlunoEntity> findById(Long id) {
        return alunoRepository.findById(id);
    }

    public AlunoEntity save(AlunoEntity aluno) {
        return alunoRepository.save(aluno);
    }

    public void deleteById(Long id) {
        alunoRepository.deleteById(id);
    }
}

