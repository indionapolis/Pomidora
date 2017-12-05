package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        double i = 0, x = 0, sr = 0;

        while (x != -1){
            x = Integer.parseInt(input.readLine());
            sr += x;
            i++;
        }
        System.out.println((sr+1)/(i-1));
    }
}

