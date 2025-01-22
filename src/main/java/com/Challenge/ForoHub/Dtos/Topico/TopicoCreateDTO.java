package com.Challenge.ForoHub.Dtos.Topico;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicoCreateDTO {
    private String titulo;
    private String mensaje;
    private String autor;
    private String curso;
}