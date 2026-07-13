package com.example.SistemaCozinhaComunitaria.Controller;



import com.example.SistemaCozinhaComunitaria.Dto.LoginDto;
import com.example.SistemaCozinhaComunitaria.Security.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthController(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        // 1. Valida email + senha usando o Spring Security
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getEmail(),
                        loginDto.getSenha()
                )
        );

        // 2. Se chegou aqui, autenticou com sucesso — gera o token
        // ⚠️ Ajustar conforme a assinatura real do seu JwtService
        String token = jwtService.generateToken(loginDto.getEmail());

        // 3. Devolve o token no corpo da resposta
        return ResponseEntity.ok(Map.of("token", token));
    }
}
