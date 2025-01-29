package com.Project;

import java.util.ArrayList;

import java.util.List;

public class Team 
{
	//Attributes:
    private String teamName;
    private List<Player> players;
    private int totalScore;
    private int strikes;
    
    //Constructor:
    public Team(String teamName) 
    {
        this.teamName = teamName;
        this.players = new ArrayList<>();
        this.totalScore = 0;
        this.strikes = 0;
    }
    
    //Setters/Getters:
    public void addPlayer(Player player) 
    {
        players.add(player);
    }

    public List<Player> getPlayers() 
    {
        return players;
    }

    public String getTeamName() 
    {
        return teamName;
    }
    
    public int getTeamScore() 
    {
        return totalScore;
    }
    
    //Adding gained points to each team's total score at the end:
    public void addScore(int points) 
    {
        this.totalScore += points;
    }
}
