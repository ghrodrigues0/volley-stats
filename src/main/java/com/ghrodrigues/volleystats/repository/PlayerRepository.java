package com.ghrodrigues.volleystats.repository;

import com.ghrodrigues.volleystats.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}