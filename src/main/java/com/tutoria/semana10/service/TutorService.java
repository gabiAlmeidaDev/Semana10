package com.tutoria.semana10.service;

import com.tutoria.semana10.entities.TutorEntity;
import com.tutoria.semana10.error.ErrorTutor;
import com.tutoria.semana10.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorService {

    private final TutorRepository tutorRepository;

    @Autowired
    public TutorService(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    public List<TutorEntity> findAll() {
        return tutorRepository.findAll();
    }

    public TutorEntity findById(Long id) {
        return tutorRepository.findById(id)
                .orElseThrow(() -> new ErrorTutor(id));
    }

    public TutorEntity save(TutorEntity tutor) {
        return tutorRepository.save(tutor);
    }

    public TutorEntity update(Long id, TutorEntity tutorDetails) {
        TutorEntity tutor = findById(id);
        tutor.setNome(tutorDetails.getNome());
        tutor.setEspecialidade(tutorDetails.getEspecialidade());
        return tutorRepository.save(tutor);
    }

    public void deleteById(Long id) {
        TutorEntity tutor = findById(id);
        tutorRepository.delete(tutor);
    }
}
