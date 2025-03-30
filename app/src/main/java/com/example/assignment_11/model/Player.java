package com.example.assignment_11.model;

import com.example.assignment_11.interfaces.SoccerEntity;

/**
 * Represents a soccer player with a name, position, and team.
 */
public class Player implements SoccerEntity {

    // Attributes
    private String name;
    private String position;
    private String team;
    private static int idCounter = 0; // Static counter for unique IDs
    private int id;

    /**
     * Constructor to initialize a new Player object.
     *
     * @param name     The name of the player.
     * @param position The position of the player.
     * @param team     The team the player belongs to.
     */
    public Player(String name, String position, String team) {
        this.name = name;
        this.position = position;
        this.team = team;
        this.id = ++idCounter; // Increment and assign a unique ID
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getTeam() {
        return team;
    }

    public int getId() {
        return id;
    }
}
