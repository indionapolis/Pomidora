package IBC2017;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by pavel on 04.08.17.
 */
public class CW1 {
    public static void main(String args[]) throws IOException {
        File inputFile = new File("input.txt");
        File outputFile = new File("output.txt");

        Scanner in = new Scanner(inputFile);

        FileWriter fileWriter = new FileWriter(outputFile);
        PrintWriter out = new PrintWriter(fileWriter);

        /*int N = in.nextInt();
        int[][] matrix = new int [N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                out.print(matrix[i][j] + " ");
            }
            if(i < N - 1) out.println();
        }*/



        out.close();
    }
}
