package com.Challenge.ForoHub.Dtos.Topico;

import com.Challenge.ForoHub.Models.Estado;

import java.time.LocalDateTime;

public record TopicoDto(Long id,
                        String titulo,
                        String mensaje,
                        String fechaCreacion,
                        Estado estado,
                        String autor,
                        String curso) {

}
