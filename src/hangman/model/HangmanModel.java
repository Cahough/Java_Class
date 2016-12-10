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

public final class HangmanModel 
{
    private int maxWrongGuesses;
    private int numGuesses;
    private int wrongGuesses;
    private final Phrase phrase;
    private String currentPhrase;
    private String hiddenPhrase;
    private List<Character> unguessedLetters;
    
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
        this.currentPhrase = phrase.getPhrase();
        this.hiddenPhrase = phrase.getHiddenPhrase();
        this.unguessedLetters = resetLettersGuessed();
    }
    
    private List<Character> resetLettersGuessed()
    {
        List<Character> unguessedLetters = new ArrayList<>();
        for (int i = 0; i < 26; i++)
        {
            Character c = (char) (i + 'A');
            unguessedLetters.add(c);
        }
        return unguessedLetters;
    }
    
    public boolean isPossibleLetter(String letter)
    {
        String u = letter.toUpperCase();
        Character c = u.charAt(0);
        return unguessedLetters.contains(c);
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
        
        Character c = upper.charAt(0);
        unguessedLetters.remove(c);
        hiddenPhrase = builder.toString();
    }
    
    public boolean isDead()
    {
        return wrongGuesses >= maxWrongGuesses;
    }
    
    public boolean isSolved()
    {
        boolean isSolved = true;
        for (int i = 0; isSolved && i < hiddenPhrase.length(); i++)
        {
            if (hiddenPhrase.charAt(i) == '_')
                isSolved = false;
        }
        return isSolved;
    }
    
    public String getUnguessedLetters()
    {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < unguessedLetters.size(); i++)
        {
            builder.append(unguessedLetters.get(i));
            if (i < (unguessedLetters.size() - 1))
                builder.append(" ");
        }
        return builder.toString();
    }
    
    public String getNumGuesses()
    {
        return Integer.toString(numGuesses);
    }
    
    public List<String> getHiddenPhrase()
    {
        List<String> lines = new ArrayList<>();
        int size = 12;
        String s = hiddenPhrase;
        
        while (s.length() > size)
        {
            int position = 0;
            while (position >= 0 && position < size)
                position = s.indexOf(" ", position+1);
            if (position >= 0)
            {
                String t = s.substring(0, position);
                lines.add(unHidePhrase(t));
                s = s.substring(position + 1);
            }
            else
                break;
        }
        
        lines.add(unHidePhrase(s));
        return lines;
    }
    
    private String unHidePhrase(String phrase)
    {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < phrase.length(); i ++)
        {
            builder.append(phrase.charAt(i));
            if (i < (phrase.length() - 1))
                builder.append(" ");
        }
        return builder.toString();
    }
    
    public int getWrongGuesses()
    {
        return wrongGuesses;
    }
    
    public String getCurrentPhrase()
    {
        return currentPhrase;
    }
}
