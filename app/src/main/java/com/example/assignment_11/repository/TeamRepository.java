package com.example.assignment_11.repository;

import com.example.assignment_11.data.DataProvider;
import com.example.assignment_11.model.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TeamRepository extends Repository<Team> {
    private List<Team> teams;

    public TeamRepository() {
        DataProvider dataProvider = new DataProvider();
        teams = dataProvider.createSampleTeams(); //loading the data here
    }

    @Override
    public List<Team> getAll() {
        return new ArrayList<>(teams);
    }

    public List<Team> filter(Predicate<Team> predicate) {
        return teams.stream().filter(predicate).collect(Collectors.toList());
    }
}
