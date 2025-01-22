//package com.Challenge.ForoHub.Dtos.Topico;
//
//import com.Challenge.ForoHub.Models.Estado;
//import com.Challenge.ForoHub.Models.Topico;
//
//import java.time.LocalDateTime;
//
//public record ObtenerTopicosDto(Long id,String titulo,String mensaje,LocalDateTime fechaCreacion,Estado estado,String autor,String curso) {
//
//    public ObtenerTopicosDto (Topico topico){
//        this(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getFechaCreacion(),topico.getEstado(),topico.getAutor(),topico.getCurso());
//    }
//}
