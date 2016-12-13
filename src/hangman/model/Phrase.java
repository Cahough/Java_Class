/*
 * Carter Hough
 * 12.12.16
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
        this.phrases.add("Hangman is fun");
        this.phrases.add("Veterinary");
        this.phrases.add("Zoologist");
        this.phrases.add("Vegetables");
        this.phrases.add("Laundry");
        this.phrases.add("Whirlwind");
        this.phrases.add("Xylophonist");
        this.phrases.add("Quadruplets");
        this.phrases.add("Quiver");
        this.phrases.add("X Ray");
        this.phrases.add("Refrigerator");
        this.phrases.add("Beautiful");
        this.phrases.add("Antidisestablishmentarianism");
    }
    
    public String getPhrase()
    {
        int nextInt = randomInt;
        while (nextInt == randomInt)
            nextInt = random.nextInt(phrases.size());
        this.randomInt = nextInt;
        this.phrase = phrases.get(randomInt);
        
        return phrase;
    }
    
    public String getHiddenPhrase()
    {
        StringBuilder hidden = new StringBuilder();
        for (int i = 0; i < phrase.length(); i++)
        {
            String s = phrase.substring(i, i+1);
            if (s.equals(" ") || s.equals(","))
                hidden.append(s);
            else
                hidden.append("_");
        }
        return hidden.toString();
    }
}
