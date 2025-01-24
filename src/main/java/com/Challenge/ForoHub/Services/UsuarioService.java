package com.Challenge.ForoHub.Services;

import com.Challenge.ForoHub.Models.Usuario;
import com.Challenge.ForoHub.Repository.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByNombre(username);

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return User.builder()
                .username(usuario.getNombre())
                .password(usuario.getContrasenia()) // Contraseña ya encriptada
                .disabled(!usuario.getActivo()) // Usuario habilitado/deshabilitado
//                .authorities(new ArrayList<>()) // Lista vacía si no manejas roles
                .build();
    }
}
