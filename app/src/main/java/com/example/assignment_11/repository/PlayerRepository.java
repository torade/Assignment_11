package com.example.assignment_11.repository;

import com.example.assignment_11.data.DataProvider;
import com.example.assignment_11.model.Player;

import java.util.List;

public class PlayerRepository extends Repository<Player> {
    private final List<Player> players;

    public PlayerRepository() {
        players = new DataProvider().createSamplePlayers();
    }

    @Override
    public List<Player> getAll() {
        return players;
    }
}
