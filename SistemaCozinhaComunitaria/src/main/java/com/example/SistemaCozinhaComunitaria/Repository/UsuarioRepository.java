package com.example.SistemaCozinhaComunitaria.Repository;

import com.example.SistemaCozinhaComunitaria.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
}
