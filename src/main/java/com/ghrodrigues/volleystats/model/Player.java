package com.ghrodrigues.volleystats.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Player {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name, position, team;
  private int jerseyNumber;

  public Player(String name, String position, String team, int jerseyNumber) {
    this.name = name;
    this.position = position;
    this.team = team;
    this.jerseyNumber = jerseyNumber;
  }

  protected Player() {
  }

  public String getName() {
    return name;
  }

  public String getPosition() {
    return position;
  }

  public String getTeam() {
    return team;
  }

  public int getJerseyNumber() {
    return jerseyNumber;
  }

  public Long getId() {
    return id;
  }

  public void setName(String newName) {
    this.name = newName;
  }

  public void setPosition(String newPosition) {
    this.position = newPosition;
  }

  public void setTeam(String newTeam) {
    this.team = newTeam;
  }

  public void setJerseyNumber(int newJerseyNumber) {
    this.jerseyNumber = newJerseyNumber;
  }

}
