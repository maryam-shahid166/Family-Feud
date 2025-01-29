package com.Project;
import java.util.*;

public class Question 
{
	//Attributes:
    String text;
    List<Answer> answers;
    
    //Constructor:
    public Question(String text, List<Answer> answers) 
    {
        this.text = text;
        this.answers = answers;
    }
}