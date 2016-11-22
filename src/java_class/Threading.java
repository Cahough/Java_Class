/*
 * Carter Hough
 * 11.21.16
 * CSCI 310 - Java
 * Assignment #5 - MultiThreading
 * Dr. MacEvoy
 * 
 * Threading.java
 */

package java_class;

class Runner implements Runnable
{
    private Thread t;
    private final String threadName;
    
    Runner(String name)
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
    
    public void start()
    {
        System.out.println("Starting " + threadName);
        if (t == null)
        {
            t = new Thread (this, threadName);
            t.start();
        }
    }
}

public class Threading
{
    public static void main(String args[])
    {
        Runner R1 = new Runner("Thread-1");
        R1.start();
        Runner R2 = new Runner("Thread-2");
        R2.start();
    }
}
