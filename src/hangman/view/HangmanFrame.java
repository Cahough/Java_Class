/*
 * Carter Hough
 * 12.9.16
 * CSCI 310: Java
 * Final Project - Hangman
 * Dr. MacEvoy
 * 
 * HangmanFrame.java
 */

package hangman.view;

import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
 
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
import hangman.model.HangmanModel;
import java.awt.Dimension;
import java.awt.Toolkit;
 
public final class HangmanFrame 
{
    private GuessPanel guessPanel;
    private final HangmanModel model;
    private HangmanPanel drawingPanel;
    private JFrame frame;
 
    public HangmanFrame(HangmanModel model) 
    {
        this.model = model;
        createPartControl();
        centerWindow();
    }
 
    protected void createPartControl() 
    {
        drawingPanel = new HangmanPanel(model);
        guessPanel = new GuessPanel(this, model);
        guessPanel.setDrawingPanel(drawingPanel);
 
        frame = new JFrame();
        frame.setTitle("Java Hangman");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() 
        {
            @Override
            public void windowClosing(WindowEvent event) 
            {
                exitProcedure();
            }
        });
 
        frame.setLayout(new FlowLayout());
 
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(guessPanel.getOutsidePanel());
        panel.add(drawingPanel);
 
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
 
    public void exitProcedure() 
    {
        frame.dispose();
        System.exit(0);
    }
 
    public JFrame getFrame() 
    {
        return frame;
    }
    
    public void centerWindow()
    {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y); 
    }
}
