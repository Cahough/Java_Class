/*
 * Carter Hough
 * 10-31-16
 * CSCI 310 - Java
 * Assignment 4 - JUnit Testing
 * Dr. MacEvoy
 * 
 * Assignment4Test.java
 */

package java_class;

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Chough
 */

public class Assignment4Test 
{
    /**
     * Test of main method, of class Assignment4.
     */
    
    @Test
    public void testMain() 
    {
        System.out.println("main");
        String[] args = null;
        Assignment4.main(args);
        
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
    }
}
