/*
 * Carter Hough
 * 12.12.16
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
import static kiss.API.*;

public class Hangman implements Runnable 
{

    @Override
    public void run() 
    {
        HangmanFrame hangmanFrame = new HangmanFrame(new HangmanModel());
    }

    public static void Run(String[] args) 
    {
        SwingUtilities.invokeLater(new Hangman());
    }
}