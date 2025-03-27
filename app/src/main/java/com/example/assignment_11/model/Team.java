package com.example.assignment_11.model;

import com.example.assignment_11.interfaces.SoccerEntity;

public class Team implements SoccerEntity {
    //attributes
    private String name, country, league;
    private int id=0;

    //constructor
    public Team(String name, String country, String league)
    {
        this.name = name;
        this.country = country;
        this.league = league;
        this.id++;
    }

    //setters
    public void setName(String name) { this.name = name; }
    public void setCountry(String country) { this.country = country; }
    public void setLeague(String league) { this.league = league; }

    //getters
    public String getName() { return this.name; }
    public String getCountry() { return this.country; }
    public String getLeague() { return this.league; }
    public int getId() { return this.id; }

}
