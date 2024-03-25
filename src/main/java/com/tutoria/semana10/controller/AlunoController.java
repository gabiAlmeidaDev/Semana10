package com.tutoria.semana10.controller;

import com.tutoria.semana10.entities.AlunoEntity;
import com.tutoria.semana10.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    @Autowired
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public ResponseEntity<List<AlunoEntity>> getAllAlunos() {
        List<AlunoEntity> alunos = alunoService.findAll();
        return ResponseEntity.ok(alunos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoEntity> getAlunoById(@PathVariable Long id) {
        return alunoService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AlunoEntity> createAluno(@RequestBody AlunoEntity aluno) {
        AlunoEntity savedAluno = alunoService.save(aluno);
        return new ResponseEntity<>(savedAluno, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoEntity> updateAluno(@PathVariable Long id, @RequestBody AlunoEntity aluno) {
        return alunoService.findById(id)
                .map(existingAluno -> {
                    aluno.setId(id);
                    AlunoEntity updatedAluno = alunoService.save(aluno);
                    return new ResponseEntity<>(updatedAluno, HttpStatus.OK);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAluno(@PathVariable Long id) {
        if (!alunoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        alunoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

