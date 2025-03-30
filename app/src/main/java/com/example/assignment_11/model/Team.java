package com.example.assignment_11.model;

import com.example.assignment_11.interfaces.SoccerEntity;

/**
 * Represents a soccer team with a name, country, and league.
 */
public class Team implements SoccerEntity {

    // Attributes
    private String name;
    private String country;
    private String league;
    private static int idCounter = 0; // Static counter for unique IDs
    private int id;

    /**
     * Constructor to initialize a new Team object.
     *
     * @param name    The name of the team.
     * @param country The country of the team.
     * @param league  The league the team belongs to.
     */
    public Team(String name, String country, String league) {
        this.name = name;
        this.country = country;
        this.league = league;
        this.id = ++idCounter; // Increment and assign a unique ID
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getLeague() {
        return league;
    }

    public int getId() {
        return id;
    }
}
