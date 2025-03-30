package com.example.assignment_11.repository;

import com.example.assignment_11.data.DataProvider;
import com.example.assignment_11.model.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TeamRepository extends Repository<Team> {

    // List to hold team data
    private final List<Team> teams;

    /**
     * Constructor to initialize the repository with sample data.
     */
    public TeamRepository() {
        // Initialize DataProvider and load sample teams
        DataProvider dataProvider = new DataProvider();
        this.teams = dataProvider.createSampleTeams();
    }

    /**
     * Returns a list of all teams.
     *
     * @return A new list containing all teams.
     */
    @Override
    public List<Team> getAll() {
        return new ArrayList<>(teams);
    }

    /**
     * Filters the list of teams based on the given predicate.
     *
     * @param predicate The condition to filter teams.
     * @return A list of teams that match the predicate.
     */
    public List<Team> filter(Predicate<Team> predicate) {
        return teams.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
