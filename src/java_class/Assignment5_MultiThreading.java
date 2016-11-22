/*
 * Carter Hough
 * 11.21.16
 * CSCI 310 - Java
 * Assignment #5 - MultiThreading
 * Dr. MacEvoy
 * 
 * Assignment5_MultiThreading.java
 */

package java_class;

public class Assignment5_MultiThreading implements Runnable
{
    private Thread t;
    private String threadName;
    
    Assignment5_MultiThreading(String name)
    {
        threadName = name;
        System.out.println("Creating " + threadName);
    }
    
    @Override
    public void run()
    {
        System.out.println("Running" + threadName);
        try
        {
            for (int i = 4; i >0; i--)
            {
                System.out.println("Thread: " + threadName + ", " + i);
                Thread.sleep(50);
            }
        }
        catch(InterruptedException e)
        {
            System.out.println("Thread: " + threadName + " interrupted.");
        }
        System.out.println("Thread: " + threadName + " exiting.");
    }
}
