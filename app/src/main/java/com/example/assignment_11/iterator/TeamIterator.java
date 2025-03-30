package com.example.assignment_11.iterator;

import com.example.assignment_11.model.Team;

import java.util.List;

public class TeamIterator extends CustomIterator<Team> {
    public TeamIterator(List<Team> teams) {
        super(teams);
    }
}