/*
 * Carter Hough
 * 12.8.16
 * CSCI 310: Java
 * Final Project - Hangman
 * Dr. MacEvoy
 * 
 * Phrase.java
 */

package hangman.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Phrase 
{
    private int randomInt;
    private final List<String> phrases;
    private final Random random;
    private String phrase;
    
    public Phrase()
    {
        random = new Random();
        this.randomInt = -1;
        this.phrases = new ArrayList<>();
        this.phrases.add("Hello World");
        this.phrases.add("Hangman is fun!");
        // add more phrases
    }
    
    public String getPhrase()
    {
        int nextInt = randomInt;
        while(nextInt == randomInt)
            nextInt = random.nextInt(phrases.size());
        this.randomInt = nextInt;
        this.phrase = phrases.get(randomInt);
        
        return phrase;
    }
}
