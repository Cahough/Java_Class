/*
 * Carter Hough
 * 10-31-16
 * CSCI 310 - Java
 * Assignment 4 - JUnit Testing
 * Dr. MacEvoy
 * 
 * Assignment4.java
 */

package java_class;

import java.util.*;

public class Assignment4 
{
    public static void main(String[] args) 
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