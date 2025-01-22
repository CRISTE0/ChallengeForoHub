package com.Challenge.ForoHub.Services;

import com.Challenge.ForoHub.Dtos.Topico.TopicoCreateDTO;
import com.Challenge.ForoHub.Models.Topico;
import com.Challenge.ForoHub.Repository.TopicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {


//     class TopicoService{}
    private final TopicoRepository topicoRepository;

    public TopicoService(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    public List<Topico> obtenerTodos() {
        return topicoRepository.findAll();
    }


    public Topico obtenerPorId(Long id) {
        return topicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tópico no encontrado"));
    }

    public Topico crear(TopicoCreateDTO dto) {
        Topico topico = new Topico();
        topico.setTitulo(dto.getTitulo());
        topico.setMensaje(dto.getMensaje());
        topico.setAutor(dto.getAutor());
        topico.setCurso(dto.getCurso());
        return topicoRepository.save(topico);
    }

    public Topico actualizar(Long id, TopicoCreateDTO dto) {
        Topico topico = obtenerPorId(id);
        topico.setTitulo(dto.getTitulo());
        topico.setMensaje(dto.getMensaje());
        topico.setAutor(dto.getAutor());
        topico.setCurso(dto.getCurso());
        return topicoRepository.save(topico);
    }

    public void eliminar(Long id) {
        topicoRepository.deleteById(id);
    }

}
