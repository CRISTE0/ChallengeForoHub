package com.Challenge.ForoHub.Models;

//import com.Challenge.ForoHub.Dtos.Topico.CrearTopicoDto;
import com.Challenge.ForoHub.Dtos.Topico.CrearTopicoDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String mensaje;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private Estado estado = Estado.ABIERTO;

    @Column(nullable = false)
    private String autor;

    @Column(nullable = false)
    private String curso;
//
//    public Long getId() {
//        return id;
//    }
//
//    public String getTitulo() {
//        return titulo;
//    }
//
//    public String getMensaje() {
//        return mensaje;
//    }
//
//    public LocalDateTime getFechaCreacion() {
//        return fechaCreacion;
//    }
//
//    public Estado getEstado() {
//        return estado;
//    }
//
//    public String getAutor() {
//        return autor;
//    }
//
//    public String getCurso() {
//        return curso;
//    }
//
//    public Topico(CrearTopicoDto crearTopicoDto){
//        this.titulo = crearTopicoDto.titulo();
//        this.mensaje = crearTopicoDto.mensaje();
//        this.fechaCreacion = crearTopicoDto.fechaCreacion();
//        this.estado = crearTopicoDto.estado();
//        this.autor = crearTopicoDto.autor();
//        this.curso = crearTopicoDto.curso();
//    }


    // Método estático para convertir DTO a entidad
    public static Topico toEntity(CrearTopicoDto dto) {
        return new Topico(
                null, // ID autogenerado
                dto.titulo(),
                dto.mensaje(),
                LocalDateTime.now(), // Fecha actual
                Estado.ABIERTO, // Estado inicial
                dto.autor(),
                dto.curso()
        );
    }
}
