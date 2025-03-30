package com.example.assignment_11.repository;

import com.example.assignment_11.data.DataProvider;
import com.example.assignment_11.model.Match;

import java.util.List;

public class MatchRepository extends Repository<Match> {
    private final List<Match> matches;

    public MatchRepository() {
        matches = new DataProvider().createSampleMatches();
    }

    @Override
    public List<Match> getAll() {
        return matches;
    }
}
