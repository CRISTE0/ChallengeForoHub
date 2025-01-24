package com.Challenge.ForoHub.Dtos.Topico;


import com.Challenge.ForoHub.Models.Estado;
import com.Challenge.ForoHub.Models.Topico;

import java.time.LocalDateTime;

public record CrearTopicoDto(
         String titulo,
         String mensaje,
         String autor,
         String curso
) { }
