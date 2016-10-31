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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Chough
 */

public class Assignment4Test {
    
    public Assignment4Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class Assignment4.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Assignment4.main(args);
    }
    
}
