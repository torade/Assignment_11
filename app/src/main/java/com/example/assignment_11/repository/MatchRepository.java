package com.example.assignment_11.repository;

import com.example.assignment_11.data.DataProvider;
import com.example.assignment_11.model.Match;

import java.util.List;

/**
 * A repository class for managing match data.
 */
public class MatchRepository extends Repository<Match> {

    // List to hold match data
    private final List<Match> matches;

    /**
     * Constructor to initialize the repository with sample match data.
     */
    public MatchRepository() {
        // Initialize DataProvider and load sample matches
        this.matches = new DataProvider().createSampleMatches();
    }

    /**
     * Returns a list of all matches.
     *
     * @return A list containing all matches.
     */
    @Override
    public List<Match> getAll() {
        return matches;
    }
}
