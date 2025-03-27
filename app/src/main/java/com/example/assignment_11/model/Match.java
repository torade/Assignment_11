package com.example.assignment_11.model;

public class Match {
    //attributes
    private String homeTeam, awayTeam, score;

    //constructor
    public Match(String homeTeam, String awayTeam, String score)
    {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.score = score;
    }

    //setters
    public void setHomeTeam(String homeTeam) { this.homeTeam = homeTeam; }

    public void setAwayTeam(String awayTeam) { this.awayTeam = awayTeam; }

    public void setScore(String score) { this.score = score; }

    //getters
    public String getHomeTeam() { return this.homeTeam; }
    public String getAwayTeam() { return this.awayTeam; }
    public String getScore() { return this.score; }

}
