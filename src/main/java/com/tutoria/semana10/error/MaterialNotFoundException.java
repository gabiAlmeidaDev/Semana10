package com.tutoria.semana10.error;

public class MaterialNotFoundException extends RuntimeException {
    public MaterialNotFoundException(Long id) {
        super("Material não encontrado com id: " + id);
    }
}

