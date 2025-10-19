package com.freightportal.controller;

import com.freightportal.model.Load;
import com.freightportal.repo.LoadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/loads")
@RequiredArgsConstructor
public class LoadController {
    private final LoadRepository repo;
    private final SimpMessagingTemplate messagingTemplate;

    @GetMapping
    public List<Load> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public ResponseEntity<Load> create(@RequestBody Load load) {
        load.setCreatedAt(LocalDateTime.from(Instant.now()));
        Load saved = repo.save(load);
        messagingTemplate.convertAndSend("/topic/loads", saved);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
