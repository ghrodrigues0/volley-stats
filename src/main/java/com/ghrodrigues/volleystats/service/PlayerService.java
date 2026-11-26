package com.ghrodrigues.volleystats.service;

import com.ghrodrigues.volleystats.model.Player;
import com.ghrodrigues.volleystats.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

  private final PlayerRepository repository;

  public PlayerService(PlayerRepository repository) {
    this.repository = repository;
  }

  public List<Player> findAll() {
    return repository.findAll();
  }

  public Optional<Player> findById(Long id) {
    return repository.findById(id);
  }

  public Player create(Player player) {
    return repository.save(player);
  }

  public Optional<Player> update(Long id, Player data) {
    return findById(id).map(existing -> {
      existing.setName(data.getName());
      existing.setPosition(data.getPosition());
      existing.setJerseyNumber(data.getJerseyNumber());
      existing.setTeam(data.getTeam());
      return repository.save(existing);
    });
  }

  public boolean delete(Long id) {
    if (repository.existsById(id)) {
      repository.deleteById(id);
      return true;
    }
    return false;
  }
}