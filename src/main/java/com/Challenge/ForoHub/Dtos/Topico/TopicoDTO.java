package com.Challenge.ForoHub.Dtos.Topico;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TopicoDTO {
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private String estado;
    private String autor;
    private String curso;
}
