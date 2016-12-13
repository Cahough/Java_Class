/*
 * Carter Hough
 * 12.12.16
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
import static kiss.API.*;

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
    
    private void testresetLettersGuessed()
    {
        List<String> letters = new ArrayList<>();
        List<Character> unguessedLetters = new ArrayList<>();
        letters.add("A"); letters.add("B"); letters.add("C"); letters.add("D");
        letters.add("E"); letters.add("F"); letters.add("G"); letters.add("H");
        letters.add("I"); letters.add("J"); letters.add("K"); letters.add("L");
        letters.add("M"); letters.add("N"); letters.add("O"); letters.add("P");
        letters.add("Q"); letters.add("R"); letters.add("S"); letters.add("T");
        letters.add("U"); letters.add("V"); letters.add("W"); letters.add("X");
        letters.add("Y"); letters.add("Z");
        
        for (int i = 0; i < 26; i++)
        {
            Character c = (char) (i + 'A');
            unguessedLetters.add(c);
            assert letters.containsAll(unguessedLetters) == true;
        }
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
    
    public void testisPossibleLetter()
    {
        char a = 'A';
        assert unguessedLetters.contains(a) == true;
    }
    
    public boolean isPossibleLetter(String letter)
    {
        String u = letter.toUpperCase();
        Character c = u.charAt(0);
        return unguessedLetters.contains(c);
    }
    
    public void testguessLetter()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("HelloWorld");
        String str = builder.toString();
        try (Close out = outExpect("HelloWorld")) 
        {
            println(str);
        }
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
    
    public void testisDead()
    {
        assert wrongGuesses >= maxWrongGuesses;
    }
    
    public boolean isDead()
    {
        return wrongGuesses >= maxWrongGuesses;
    }
    
    public void testisSolved()
    {
        boolean isSolved = true;
        String testPhrase = "Hello World";
        for (int i = 0; isSolved && i < testPhrase.length(); i++)
        {
            if (testPhrase.charAt(i) == '_')
                isSolved = false;
        }
        assert isSolved == true;
        
        String testPhrase2 = "Hello _orld";
        for (int i = 0; isSolved && i < testPhrase2.length(); i++)
        {
            if (testPhrase2.charAt(i) == '_')
                isSolved = false;
        }
        assert isSolved == false;
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
    
    public void testgetUnguessedLetters()
    {
        StringBuilder test = new StringBuilder();
        for (int i = 0; i < unguessedLetters.size(); i++)
        {
            test.append(unguessedLetters.get(i));
            if (i < (unguessedLetters.size() - 1))
                test.append(" ");
            assert test(i).equals(unguessedLetters.get(i));
        }
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
    
    public void testgetNumGuesses()
    {
        assert Integer.toString(numGuesses).getClass().getName() == "String";
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
