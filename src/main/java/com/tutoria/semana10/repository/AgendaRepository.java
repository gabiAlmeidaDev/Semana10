package com.tutoria.semana10.repository;

import com.tutoria.semana10.entities.AgendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AgendaRepository extends JpaRepository<AgendaEntity, Long> {
    List<AgendaEntity> findByAlunoIdOrderByDataAsc(Long alunoId);
    List<AgendaEntity> findByTutorIdOrderByDataAsc(Long tutorId);

    List<AgendaEntity> findByAlunoIdAndDataAfterOrderByDataAsc(Long alunoId, LocalDateTime data);
    List<AgendaEntity> findByTutorIdAndDataAfterOrderByDataAsc(Long tutorId, LocalDateTime data);

}

