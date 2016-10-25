/*
 * Carter Hough
 * 10.24.16
 * CSCI 310 - Java
 * Assignment 2 - Collections
 * Dr. MacEvoy
 * 
 * Assignment3_Testing.java
 */

// This program is for Assignment 3 to continue further testing on the program
//  from Assignment 2.

package java_class;

import static kiss.API.*;
import java.util.*;

public class Assignment3_Testing 
{
    void testRun()
    {
        ArrayList[] set = new ArrayList[5];
        set[0] = new ArrayList(5);
        set[0].add(41);
        set[0].add(77);
        set[0].add(74);
        set[0].add(22);
        set[0].add(44);
        
        set[1] = new ArrayList(1);
        set[1].add(12);
        
        set[2] = new ArrayList(4);
        set[2].add(37);
        set[2].add(34);
        set[2].add(36);
        set[2].add(52);
        
        set[3] = new ArrayList(0);
        
        set[4] = new ArrayList(3);
        set[4].add(20);
        set[4].add(22);
        set[4].add(33);
        
        assert set[0].get(4).equals(44);
        assert set[1].get(0).equals(12);
        assert set[2].get(2).equals(36);
        assert set[3].isEmpty();
        assert set[4].get(0).equals(20);
        
        try (Close out = outExpect(
                "The number located at [1, 3] is: 74", EOL,
                "The number located at [3, 4] is: 52", EOL,
                "The number located at [3, 1] is: 37", EOL,
                "ERROR!"))
        {
            try
            {
                println("The number located at [1, 3] is: " + set[1-1].get(3-1));
                println("The number located at [3, 4] is: " + set[3-1].get(4-1));
                println("The number located at [3, 1] is: " + set[3-1].get(1-1));
                println("The number located at [4, 3] is: " + set[4-1].get(3-1));
            }
            catch (Exception e)
            {
                println("ERROR!");
            }
        }
    }
    
    void run() 
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Input Format:\n"
                + " The first line has an integer 'n'. In each of the next 'n' lines there will be an integer 'd'\n"
                + " denoting number of integers on that line and then there will be 'd' space-separated integers.\n"
                + " In the next line there will be an integer 'q' denoting number of queries.\n"
                + " Each query will consist of two integers 'x' and 'y'.");
        
        int n = input.nextInt();
        int d = 0, q = 0, x = 0, y = 0;
        ArrayList[] set = new ArrayList[n];
        
        for (int i = 0; i < n; i++) 
        {
            d = input.nextInt();
            set[i] = new ArrayList();
            for (int j = 0; j < d; j++)
            {
                set[i].add(input.nextInt());
            }
        }
        
        q = input.nextInt();
        for (int i = 0; i < q; i++)
        {
            x = input.nextInt();
            y = input.nextInt();
            try 
            {
                System.out.println("The number located at [" + x + ", " + y + "] is: " + set[x - 1].get(y - 1));
            } 
            catch (Exception e) 
            {
                System.out.println("ERROR!");
            }
        }
    }
}
