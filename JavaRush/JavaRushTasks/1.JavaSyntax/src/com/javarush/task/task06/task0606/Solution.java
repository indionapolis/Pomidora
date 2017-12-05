package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int d = Integer.parseInt(in.readLine());
        while (d != 0){
            if (d % 2 == 0){even++;}
            else {odd++;}
            d = d/10;
        }
        System.out.println("Even: "+even+" Odd: "+odd );
    }
}
