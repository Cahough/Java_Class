/*
 * Carter Hough
 * 12.9.16
 * CSCI 310: Java
 * Final Project - Hangman
 * Dr. MacEvoy
 * 
 * Hangman.java
 */

package hangman;

import javax.swing.SwingUtilities;
import hangman.model.HangmanModel;
import hangman.view.HangmanFrame;

public class Hangman implements Runnable 
{

    @Override
    public void run() 
    {
        HangmanFrame hangmanFrame = new HangmanFrame(new HangmanModel());
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(new Hangman());
    }
}