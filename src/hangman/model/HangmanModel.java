/*
 * Carter Hough
 * 12.9.16
 * CSCI 310: Java
 * Final Project - Hangman
 * Dr. MacEvoy
 * 
 * HangmanModel.java
 */

package hangman.model;

import java.util.ArrayList;
import java.util.List;
import hangman.view.HangmanPanel;

public class HangmanModel 
{
    int maxWrongGuesses;
    int numGuesses;
    int wrongGuesses;
    Phrase phrase;
    String currentPhrase;
    String hiddenPhrase;
    List<Character> unguessedLetters;
    
    public HangmanModel()
    {
        this.phrase = new Phrase();
        init();
    }
    
    public void init()
    {
        this.maxWrongGuesses = HangmanPanel.maxWrongGuesses;
        this.numGuesses = 0;
        this.wrongGuesses = 0;
        this.currentPhrase = Phrase.getPhrase();
        this.hiddenPhrase = Phrase.getHiddenPhrase();
        this.unguessedLetters = resetLettersGuessed();
    }
    
    private List<Character> resetLettersGuessed()
    {
        List<Character> unguessedLetters = new ArrayList<>();
        for (int i = 0; i < 26; i++)
        {
            Character c = (char) (i+'A');
            unguessedLetters.add(c);
        }
        return unguessedLetters;
    }
    
    public boolean isPossibleLetter(String letter)
    {
        return unguessedLetters.contains(letter.toUpperCase().charAt(0));
    }
    
    public void guessLetter(String letter)
    {
        String lower = letter.toLowerCase();
        String upper = letter.toUpperCase();
        StringBuilder builder = new StringBuilder();
        boolean incorrectGuess = true;
        
        for (int i = 0; i < currentPhrase.length(); i++)
        {
            String s = currentPhrase.substring(i, i+1);
            if (lower.equals(s.toLowerCase()))
            {
                builder.append(s);
                incorrectGuess = false;
            }
            else
                builder.append(hiddenPhrase.charAt(i));
        }
        numGuesses++;
        
        if (incorrectGuess)
            wrongGuesses++;
        
        unguessedLetters.remove(upper.charAt(0));
        hiddenPhrase = builder.toString();
    }
}
