package com.ghrodrigues.volleystats.controller;

import com.ghrodrigues.volleystats.model.Player;
import com.ghrodrigues.volleystats.repository.PlayerRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

  private final PlayerRepository repository;

  public PlayerController(PlayerRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public List<Player> getAll() {
    return repository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Player> getById(@PathVariable Long id) {
    return repository.findById(id)
        .map(player -> ResponseEntity.ok(player))
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Player> create(@RequestBody Player player) {
    return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(player));
  }
}