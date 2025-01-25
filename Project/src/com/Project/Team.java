package com.Project;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String teamName;
    private List<Player> players;
    private int totalScore;

    public Team(String teamName) {
        this.teamName = teamName;
        this.players = new ArrayList<>();
        this.totalScore = 0;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int calculateTotalScore() {
        totalScore = 0;
        for (Player player : players) {
            totalScore += player.getScore();
        }
        return totalScore;
    }

    public String getTeamName() {
        return teamName;
    }
}
