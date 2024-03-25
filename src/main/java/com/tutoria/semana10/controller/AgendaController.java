package com.tutoria.semana10.controller;

import com.tutoria.semana10.entities.AgendaEntity;
import com.tutoria.semana10.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendas")
public class AgendaController {

    private final AgendaService agendaService;

    @Autowired
    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @GetMapping
    public ResponseEntity<List<AgendaEntity>> getAllAgendas() {
        List<AgendaEntity> agendas = agendaService.findAll();
        return ResponseEntity.ok(agendas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendaEntity> getAgendaById(@PathVariable Long id) {
        AgendaEntity agenda = agendaService.findById(id);
        return ResponseEntity.ok(agenda);
    }

    @PostMapping
    public ResponseEntity<AgendaEntity> createAgenda(@RequestBody AgendaEntity agenda) {
        AgendaEntity savedAgenda = agendaService.save(agenda);
        return new ResponseEntity<>(savedAgenda, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgendaEntity> updateAgenda(@PathVariable Long id, @RequestBody AgendaEntity agendaDetails) {
        AgendaEntity updatedAgenda = agendaService.update(id, agendaDetails);
        return ResponseEntity.ok(updatedAgenda);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgenda(@PathVariable Long id) {
        agendaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/aluno-id/{alunoId}")
    public ResponseEntity<List<AgendaEntity>> getAgendasByAlunoId(@PathVariable Long alunoId) {
        List<AgendaEntity> agendas = agendaService.findAgendasByAlunoId(alunoId);
        return ResponseEntity.ok(agendas);
    }

    @GetMapping("/tutor-id/{tutorId}")
    public ResponseEntity<List<AgendaEntity>> getAgendasByTutorId(@PathVariable Long tutorId) {
        List<AgendaEntity> agendas = agendaService.findAgendasByTutorId(tutorId);
        return ResponseEntity.ok(agendas);
    }

    @GetMapping("/proximos/aluno-id/{alunoId}")
    public ResponseEntity<List<AgendaEntity>> getProximosAgendamentosByAlunoId(@PathVariable Long alunoId) {
        List<AgendaEntity> agendas = agendaService.findProximosAgendamentosByAlunoId(alunoId);
        return ResponseEntity.ok(agendas);
    }

    @GetMapping("/proximos/tutor-id/{tutorId}")
    public ResponseEntity<List<AgendaEntity>> getProximosAgendamentosByTutorId(@PathVariable Long tutorId) {
        List<AgendaEntity> agendas = agendaService.findProximosAgendamentosByTutorId(tutorId);
        return ResponseEntity.ok(agendas);
    }
}

