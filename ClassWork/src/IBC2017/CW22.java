package sawe; /**
 * Project name: ClassWork
 * Created by pavel on 09.08.17.
 */
import java.util.*;


public class CW22 {
     public static void main(String args[])
    {
        long start = System.currentTimeMillis();
        for(int i = 1;i <= 10;i++)
        {
            System.out.println((int)(Math.random()*10));
        }
        long timeWorkCode = System.currentTimeMillis() - start;
        System.out.println("Program run-time is " + timeWorkCode + " milisecond(s)");
    }
}
