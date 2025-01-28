package com.Project;

import java.util.ArrayList;

import java.util.List;

public class Team 
{
    private String teamName;
    private List<Player> players;
    private int totalScore;
    private int strikes;

    public Team(String teamName) 
    {
        this.teamName = teamName;
        this.players = new ArrayList<>();
        this.totalScore = 0;
        this.strikes = 0;
    }

    public void addPlayer(Player player) 
    {
        players.add(player);
    }

    public List<Player> getPlayers() 
    {
        return players;
    }

    public void addScore(int points) 
    {
        this.totalScore += points;
    }

    public String getTeamName() 
    {
        return teamName;
    }
    
    public int getTeamScore() 
    {
        return totalScore;
    }
}
