package com.example.assignment_11.iterator;

import com.example.assignment_11.model.Team;

import java.util.List;

/**
 * An iterator for traversing a list of Team objects.
 */
public class TeamIterator extends CustomIterator<Team> {

    /**
     * Constructor to initialize the iterator with a list of teams.
     *
     * @param teams The list of teams to iterate over.
     */
    public TeamIterator(List<Team> teams) {
        super(teams);
    }
}
