package com.tutoria.semana10.error;

public class AgendaNotFoundException extends RuntimeException {
    public AgendaNotFoundException(Long id) {
        super("Agendamento não encontrado com id: " + id);
    }
}

