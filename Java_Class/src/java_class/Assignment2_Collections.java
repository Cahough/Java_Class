/*
 * Carter Hough
 * 10.10.16
 * CSCI 310 - Java
 * Assignment 2 - Collections
 * Dr. MacEvoy
 * 
 * Assignment2_Collections.java
 */

// This program is for Assignment 2 to get familiar with collections. I decided
//  to play with ArrayList and found a challenge on HackerRank to help familiarize
//  myself with them.
//  Challenge Address: https://www.hackerrank.com/challenges/java-arraylist?h_r=internal-search

package java_class;

import static kiss.API.*;
import java.util.*;

public class Assignment2_Collections 
{
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
