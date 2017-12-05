package AUG2017;

import java.util.Random;

/**
 * Project name: ClassWork
 * Created by pavel on 22.08.17.
 */
public class CW8 {
    public static void main(String[] args) {
        //int size = 0;
        //int[] m = new int[size];
        //Random random = new Random();
        //for (int i = 0; i < m.length; i++) {
        //    m[i] = random.nextInt(m.length);
        //}
        //for (int i = 0; i < m.length; i++) {
        //    System.out.print(m[i] + "  ");
        //    if (i%20 == 19){
        //        System.out.println("");
        //    }
        //}
        //System.out.println("");
        //System.out.println(FME(m));
        System.out.println(Factorial(16));
    }

    public static int FME(int[] arr){
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }

    public static int Factorial(int n){
        if (n == 0){
            return 1;
        }else{
            return n * Factorial(n-1);
        }
    }
}
