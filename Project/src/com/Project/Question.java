package com.Project;
import java.util.*;

public class Question 
{
    String text;
    List<Answer> answers;

    public Question(String text, List<Answer> answers) 
    {
        this.text = text;
        this.answers = answers;
    }
}