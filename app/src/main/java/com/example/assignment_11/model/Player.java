package com.example.assignment_11.model;

import com.example.assignment_11.interfaces.SoccerEntity;

public class Player implements SoccerEntity {

    //attributes
    private String name, position, team;
    private int id = 0;

    //constructor
    public Player(String name, String position, String team)
    {
        this.name = name;
        this.position = position;
        this.team = team;
        this.id++;
    }

    //setters
    public void setName(String name) { this.name = name; }
    public void setPosition(String position) { this.position = position; }
    public void setTeam(String team) { this.team = team; }

    //getters
    public String getName() { return this.name; }
    public String getPosition() { return this.position; }
    public String getTeam(){ return this.team; }
    public int getId() { return this.id; }
}
