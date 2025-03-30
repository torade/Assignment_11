package com.example.assignment_11.model;

/**
 * Represents a soccer match with home team, away team, and score.
 */
public class Match {

    // Attributes
    private String homeTeam;
    private String awayTeam;
    private String score;

    /**
     * Constructor to initialize a new Match object.
     *
     * @param homeTeam The name of the home team.
     * @param awayTeam The name of the away team.
     * @param score    The score of the match.
     */
    public Match(String homeTeam, String awayTeam, String score) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.score = score;
    }

    // Setters
    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public void setScore(String score) {
        this.score = score;
    }

    // Getters
    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public String getScore() {
        return score;
    }
}
