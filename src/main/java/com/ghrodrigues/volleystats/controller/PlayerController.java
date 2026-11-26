package com.ghrodrigues.volleystats.controller;

import com.ghrodrigues.volleystats.model.Player;
import com.ghrodrigues.volleystats.service.PlayerService;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

  private final PlayerService service;

  public PlayerController(PlayerService service) {
    this.service = service;
  }

  @GetMapping
  public List<Player> getAll() {
    return service.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Player> getById(@PathVariable Long id) {
    return service.findById(id)
        .map(player -> ResponseEntity.ok(player))
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Player> create(@RequestBody Player player) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.create(player));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Player> update(@PathVariable Long id, @RequestBody Player player) {
    return service.update(id, player)
        .map(updated -> ResponseEntity.ok(updated))
        .orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    if (service.delete(id)) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }
}