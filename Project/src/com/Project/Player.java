package com.Project;

public class Player 
{
	//Attributes:
    private String name;
    private int score;
    
    //Constructor:
    public Player(String name) 
    {
        this.name = name;
        this.score = 0;
    }
    
    //Setters/Getters:
    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public int getScore() 
    {
        return score;
    }

    public void setScore(int score) 
    {
        this.score = score;
    }
    
//    public void updateScore(int points) 
//    {
//        this.score += points;
//    }
}
