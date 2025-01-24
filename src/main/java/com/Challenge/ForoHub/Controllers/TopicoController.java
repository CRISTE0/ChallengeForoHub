package com.Challenge.ForoHub.Controllers;

//import com.Challenge.ForoHub.Dtos.Topico.ObtenerTopicosDto;
import com.Challenge.ForoHub.Dtos.Topico.ActualizarTopicoDto;
import com.Challenge.ForoHub.Dtos.Topico.CrearTopicoDto;
import com.Challenge.ForoHub.Dtos.Topico.TopicoDto;

import com.Challenge.ForoHub.Services.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<TopicoDto> obtenerTodos() {
        return topicoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicoDto> obtenerPorId(@PathVariable Long id) {
        TopicoDto topico = topicoService.obtenerPorId(id);

        return ResponseEntity.ok(topico);
    }

    @PostMapping
    public ResponseEntity<TopicoDto> crear(@Valid @RequestBody CrearTopicoDto dto) {
        return ResponseEntity.ok(topicoService.crear(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TopicoDto> actualizar(@PathVariable Long id, @Valid @RequestBody ActualizarTopicoDto dto) {
        return ResponseEntity.ok(topicoService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        topicoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }


}
