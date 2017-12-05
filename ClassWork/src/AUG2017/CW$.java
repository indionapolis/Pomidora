package AUG2017;

import java.util.Scanner;

/**
 * Project name: ClassWork
 * Created by pavel on 15.08.17.
 */
public class CW$ {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int LA[] = new int[7];
        for (int i = 0; i < 6; i++) {
            LA[i] = in.nextInt();
        }
        int K = in.nextInt();
        int item = in.nextInt();
        for (int i = 6; i >= K; i--) {
            LA[i] = LA[i-1];
        }
        LA[K-1] = item;
        for (int i = 0; i < 7; i++) {
            System.out.print(LA[i] + " ");
        }
        System.out.println("");
        for (int i = K-1; i < 6; i++) {
            LA[i] = LA[i+1];
        }
        for (int i = 0; i < 6; i++) {
            System.out.print(LA[i] + " ");
        }

    }
}
