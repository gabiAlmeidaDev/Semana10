package com.tutoria.semana10.repository;

import com.tutoria.semana10.entities.AgendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepository extends JpaRepository<AgendaEntity, Long> {
}

