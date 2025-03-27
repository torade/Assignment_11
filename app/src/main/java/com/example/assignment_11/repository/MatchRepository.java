package com.example.assignment_11.repository;

import com.example.assignment_11.model.Match;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MatchRepository extends Repository<Match>{

    /**
     * Filters the matches by the given team.
     * @param team (team name) = filter criteria
     * @return list of matches using stream and lambda functions
     */
    public List<Match> filterByTeam(String team)
    {
       return getAll().stream()
               .filter(match -> match.getHomeTeam().equalsIgnoreCase(team) || match.getAwayTeam().equalsIgnoreCase(team))
               .collect(Collectors.toList());
    }



}
