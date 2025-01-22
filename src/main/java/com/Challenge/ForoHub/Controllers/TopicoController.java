package com.Challenge.ForoHub.Controllers;

//import com.Challenge.ForoHub.Dtos.Topico.ObtenerTopicosDto;
import com.Challenge.ForoHub.Dtos.Topico.TopicoCreateDTO;
import com.Challenge.ForoHub.Dtos.Topico.TopicoDTO;
import com.Challenge.ForoHub.Models.Topico;
import com.Challenge.ForoHub.Repository.TopicoRepository;
import com.Challenge.ForoHub.Services.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topicos")
public class TopicoController {

    @Autowired(required = true)
    private final TopicoService topicoService;

//    @GetMapping
//    public Page<ObtenerTopicosDto> listaTopicos(@PageableDefault(size = 2) Pageable paginacion){

//        return topicoRepository.obtenerTopicoPorEstatus(paginacion).map(ObtenerTopicosDto::new);
//    }

    public TopicoController(TopicoService topicoService) {
        this.topicoService = topicoService;
    }

    @GetMapping
    public List<TopicoDTO> obtenerTodos() {
        return topicoService.obtenerTodos()
                .stream()
                .map(topico -> {
                    TopicoDTO dto = new TopicoDTO();
                    dto.setId(topico.getId());
                    dto.setTitulo(topico.getTitulo());
                    dto.setMensaje(topico.getMensaje());
                    dto.setFechaCreacion(topico.getFechaCreacion());
                    dto.setEstado(topico.getEstado().toString());
                    dto.setAutor(topico.getAutor());
                    dto.setCurso(topico.getCurso());
                    return dto;
                })
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicoDTO> obtenerPorId(@PathVariable Long id) {
        Topico topico = topicoService.obtenerPorId(id);
        TopicoDTO dto = new TopicoDTO();
        dto.setId(topico.getId());
        dto.setTitulo(topico.getTitulo());
        dto.setMensaje(topico.getMensaje());
        dto.setFechaCreacion(topico.getFechaCreacion());
        dto.setEstado(topico.getEstado().toString());
        dto.setAutor(topico.getAutor());
        dto.setCurso(topico.getCurso());
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<Topico> crear(@Valid @RequestBody TopicoCreateDTO dto) {
        return ResponseEntity.ok(topicoService.crear(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topico> actualizar(@PathVariable Long id, @Valid @RequestBody TopicoCreateDTO dto) {
        return ResponseEntity.ok(topicoService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        topicoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }


}
