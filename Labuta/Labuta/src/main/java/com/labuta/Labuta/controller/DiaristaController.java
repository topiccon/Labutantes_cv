package com.labuta.Labuta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labuta.Labuta.model.User;
import com.labuta.Labuta.repository.UserRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/diaristas")
public class DiaristaController {

    @Autowired
    private UserRepository userRepository;

    // Construtor para permitir injeção de dependência manual (se necessário)
    public DiaristaController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // POST — Cadastrar nova diarista
    @PostMapping
    public ResponseEntity<User> cadastrarDiarista(@RequestBody User diarista) {
        if (diarista.getName() == null || diarista.getEmail() == null) {
            return ResponseEntity.badRequest().build();
        }

        diarista.setType("diarista");
        User savedDiarista = userRepository.save(diarista);
        return ResponseEntity.ok(savedDiarista);
    }

    // GET — Listar todas as diaristas
    @GetMapping
    public ResponseEntity<List<User>> listarDiaristas() {
        List<User> diaristas = userRepository.findAll()
                .stream()
                .filter(u -> "diarista".equals(u.getType()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(diaristas);
    }

    // GET — Buscar diarista por ID
    @GetMapping("/{id}")
    public ResponseEntity<User> buscarDiarista(@PathVariable Long id) {
        Optional<User> diarista = userRepository.findById(id);
        if (diarista.isPresent() && "diarista".equals(diarista.get().getType())) {
            return ResponseEntity.ok(diarista.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Getters e Setters (pouco usados, mas mantidos para boas práticas)
    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}

