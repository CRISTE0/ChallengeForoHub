package com.Challenge.ForoHub.Services;

import com.Challenge.ForoHub.Dtos.Topico.ActualizarTopicoDto;
import com.Challenge.ForoHub.Dtos.Topico.CrearTopicoDto;
import com.Challenge.ForoHub.Dtos.Topico.TopicoDto;
import com.Challenge.ForoHub.Mapper.TopicoMapper;
import com.Challenge.ForoHub.Models.Topico;
import com.Challenge.ForoHub.Repository.TopicoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicoService {


//     class TopicoService{}
    private final TopicoRepository topicoRepository;
    private final TopicoMapper topicoMapper;

    public TopicoService(TopicoRepository topicoRepository, TopicoMapper topicoMapper) {
        this.topicoRepository = topicoRepository;
        this.topicoMapper = topicoMapper;
    }

    public List<TopicoDto> obtenerTodos() {
        return topicoRepository.findAll().stream()
                .map(topicoMapper::toDto)
                .collect(Collectors.toList());
    }


    public TopicoDto obtenerPorId(Long id) {
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tópico no encontrado"));

        return topicoMapper.toDto(topico);
    }

    public TopicoDto crear(CrearTopicoDto dto) {
        Topico topico = topicoMapper.toEntity(dto);
        topico = topicoRepository.save(topico);

        return topicoMapper.toDto(topico);
    }

    public TopicoDto actualizar(Long id, ActualizarTopicoDto dto) {

        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tópico no encontrado con el id: " + id));

        // Actualizamos los campos
        topico.setTitulo(dto.titulo());
        topico.setMensaje(dto.mensaje());
        topico.setCurso(dto.curso());

        // Guardamos los cambios
        Topico topicoActualizado = topicoRepository.save(topico);

        return topicoMapper.toDto(topicoActualizado);
    }

    public void eliminar(Long id) {
        topicoRepository.deleteById(id);
    }

}
