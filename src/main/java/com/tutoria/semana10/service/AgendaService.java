package com.tutoria.semana10.service;

import com.tutoria.semana10.entities.AgendaEntity;
import com.tutoria.semana10.error.AgendaNotFoundException;
import com.tutoria.semana10.repository.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaService {

    private final AgendaRepository agendaRepository;

    @Autowired
    public AgendaService(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    public List<AgendaEntity> findAll() {
        return agendaRepository.findAll();
    }

    public AgendaEntity findById(Long id) {
        return agendaRepository.findById(id)
                .orElseThrow(() -> new AgendaNotFoundException(id));
    }

    public AgendaEntity save(AgendaEntity agenda) {
        return agendaRepository.save(agenda);
    }

    public AgendaEntity update(Long id, AgendaEntity agendaDetails) {
        AgendaEntity agenda = findById(id);
        agenda.setAluno(agendaDetails.getAluno());
        agenda.setTutor(agendaDetails.getTutor());
        agenda.setData(agendaDetails.getData());
        agenda.setStatus(agendaDetails.getStatus());
        agenda.setTema(agendaDetails.getTema());
        agenda.setDescricaoBreve(agendaDetails.getDescricaoBreve());
        return agendaRepository.save(agenda);
    }

    public void deleteById(Long id) {
        AgendaEntity agenda = findById(id);
        agendaRepository.delete(agenda);
    }
}
