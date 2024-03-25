package com.tutoria.semana10.repository;

import com.tutoria.semana10.entities.TutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorRepository extends JpaRepository<TutorEntity, Long> {
}

