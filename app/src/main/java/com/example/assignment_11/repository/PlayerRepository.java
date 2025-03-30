package com.example.assignment_11.repository;

import com.example.assignment_11.data.DataProvider;
import com.example.assignment_11.model.Player;

import java.util.List;

/**
 * A repository class for managing player data.
 */
public class PlayerRepository extends Repository<Player> {

    // List to hold player data
    private final List<Player> players;

    /**
     * Constructor to initialize the repository with sample player data.
     */
    public PlayerRepository() {
        // Initialize DataProvider and load sample players
        this.players = new DataProvider().createSamplePlayers();
    }

    /**
     * Returns a list of all players.
     *
     * @return A list containing all players.
     */
    @Override
    public List<Player> getAll() {
        return players;
    }
}
