package AUG2017;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Project name: ClassWork
 * Created by pavel on 13.08.17.
 */
public class Tutorial13 {
    public static void main(String args[]) throws IOException {
        File inputFile = new File("input.txt");
        File outputFile = new File("output.txt");
        Scanner in = new Scanner(inputFile);
        PrintWriter out = new PrintWriter(new FileWriter(outputFile));
        int i = 0;
        int digit = 0;
        while (in.hasNextInt()){
            digit += in.nextInt();
            i++;
        }
        if (i != 3){
            out.print("NOT ENOUGH NUMBERS");
        }
        else {
            out.print(digit);
        }

        out.close();
    }
}
