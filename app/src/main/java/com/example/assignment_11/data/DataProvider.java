package com.example.assignment_11.data;

import com.example.assignment_11.model.Match;
import com.example.assignment_11.model.Player;
import com.example.assignment_11.model.Team;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides sample data for teams, players, and matches.
 */
public class DataProvider {

    /**
     * Creates a list of sample teams.
     *
     * @return A list of sample teams.
     */
    public List<Team> createSampleTeams() {
        List<Team> teams = new ArrayList<>();
        teams.add(new Team("FC Barcelona", "Spain", "La Liga"));
        teams.add(new Team("Manchester United", "England", "Premier League"));
        teams.add(new Team("Bayern Munich", "Germany", "Bundesliga"));
        teams.add(new Team("Juventus", "Italy", "Serie A"));
        teams.add(new Team("Paris Saint-Germain", "France", "Ligue 1"));
        teams.add(new Team("Ajax Amsterdam", "Netherlands", "Eredivisie"));
        teams.add(new Team("River Plate", "Argentina", "Primera División"));
        teams.add(new Team("Flamengo", "Brazil", "Brasileirão"));
        return teams;
    }

    /**
     * Creates a list of sample players.
     *
     * @return A list of sample players.
     */
    public List<Player> createSamplePlayers() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Lionel Messi", "Forward", "FC Barcelona"));
        players.add(new Player("Cristiano Ronaldo", "Forward", "Juventus"));
        players.add(new Player("Robert Lewandowski", "Forward", "Bayern Munich"));
        players.add(new Player("Kevin De Bruyne", "Midfielder", "Manchester City"));
        players.add(new Player("Virgil van Dijk", "Defender", "Liverpool"));
        players.add(new Player("Manuel Neuer", "Goalkeeper", "Bayern Munich"));
        players.add(new Player("Kylian Mbappé", "Forward", "Paris Saint-Germain"));
        players.add(new Player("Erling Haaland", "Forward", "Borussia Dortmund"));
        players.add(new Player("Bruno Fernandes", "Midfielder", "Manchester United"));
        players.add(new Player("Joshua Kimmich", "Midfielder", "Bayern Munich"));
        players.add(new Player("Jan Oblak", "Goalkeeper", "Atletico Madrid"));
        players.add(new Player("Neymar Jr.", "Forward", "Paris Saint-Germain"));
        return players;
    }

    /**
     * Creates a list of sample matches.
     *
     * @return A list of sample matches.
     */
    public List<Match> createSampleMatches() {
        List<Match> matches = new ArrayList<>();
        matches.add(new Match("FC Barcelona", "Real Madrid", "2-1"));
        matches.add(new Match("Manchester United", "Liverpool", "0-3"));
        matches.add(new Match("Bayern Munich", "Borussia Dortmund", "4-2"));
        matches.add(new Match("Juventus", "AC Milan", "1-1"));
        matches.add(new Match("Paris Saint-Germain", "Lyon", "3-0"));
        matches.add(new Match("FC Barcelona", "Bayern Munich", "0-3"));
        matches.add(new Match("Manchester City", "Paris Saint-Germain", "2-1"));
        matches.add(new Match("Liverpool", "Ajax Amsterdam", "1-0"));
        return matches;
    }
}
