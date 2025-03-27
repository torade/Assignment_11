package com.example.assignment_11.repository;

import com.example.assignment_11.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerRepository extends Repository<Player>{
    /**
     * Filters the players by the given team.
     * @param team (team name) = filter criteria
     * @return list of players using stream and lambda functions
     */
    public List<Player> filterByTeam(String team)
    {
        return getAll().stream()
                .filter(player -> player.getTeam().equalsIgnoreCase(team))
                .collect(Collectors.toList());
    }

}
