package com.Challenge.ForoHub.Mapper;

import com.Challenge.ForoHub.Dtos.Topico.CrearTopicoDto;
import com.Challenge.ForoHub.Dtos.Topico.TopicoDto;
import com.Challenge.ForoHub.Models.Topico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public interface TopicoMapper {

    TopicoMapper INSTANCE = Mappers.getMapper(TopicoMapper.class);

    @Mapping(target = "fechaCreacion",expression = "java(formatearFecha(topico.getFechaCreacion()))")
    TopicoDto toDto(Topico topico);

    default String formatearFecha(LocalDateTime fechaCreacion) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
        return fechaCreacion.format(formatter);
    }

    Topico toEntity(CrearTopicoDto dto);
}
