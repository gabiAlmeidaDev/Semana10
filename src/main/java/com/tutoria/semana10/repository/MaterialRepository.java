package com.tutoria.semana10.repository;

import com.tutoria.semana10.entities.MaterialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<MaterialEntity, Long> {
}

