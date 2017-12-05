package sawe;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.Scanner;

/**
 * Project name: ClassWork
 * Created by pavel on 10.08.17.
 */
public class CW3 {
    public static void main(String[] args) {
        Coupling set = new Coupling();
        int [] inter;

        while ((inter = set.FREE()) != null){
            set.SWAP(inter[0], inter[1]);
        }
        set.input();
    }

    public static class Coupling{
        private int N;
        private Point2D.Double[] W, B;

        public Coupling(){
            Scanner in = new Scanner(System.in);

            this.N = in.nextInt();
            W = new Point2D.Double[this.N];
            B = new Point2D.Double[this.N];

            for (int i = 0; i < this.N; i++) {
                W[i] = new Point2D.Double(in.nextDouble(), in.nextDouble());
            }

            for (int i = 0; i < this.N; i++) {
                B[i] = new Point2D.Double(in.nextDouble(), in.nextDouble());
            }
        }

        int[] FREE(){
            for (int i = 0; i < this.N; i++) {
                for (int j = i + 1; j < this.N; j++) {
                    if(inter(i, j)){
                        return new int[]{i, j};
                    }
                }
            }
            return null;
        }



        boolean inter(int coup1, int coup2){
            Line2D line1 = new Line2D.Double(W[coup1], B[coup1]);
            Line2D line2 = new Line2D.Double(W[coup2], B[coup2]);
            return line1.intersectsLine(line2);
        }


        void SWAP(int coup1, int coup2){
            Point2D.Double b;
            b = W[coup1];
            W[coup1] = W[coup2];
            W[coup2] = b;
            b = B[coup1];
            B[coup1] = B[coup2];
            B[coup2] = b;
            System.out.println("SWAP " + coup1 + " & " + coup2);
        }

        void input(){
            for (int i = 0; i < N; i++) {
                System.out.println("Пара № " + i);
                System.out.println(W[i].x + " " + W[i].y +", " + B[i].x + " " + B[i].y);
            }
        }

    }
}

