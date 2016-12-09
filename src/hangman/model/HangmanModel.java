/*
 * Carter Hough
 * 12.8.16
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
}
