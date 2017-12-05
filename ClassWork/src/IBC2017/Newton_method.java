package sawe;

/**
 * Created by pavel on 04.08.17.
 */
public class Newton_method {
    public static void main(String[] args){
        double e = 0.0000001; // set accuracy
        int n = 121; // set the number from this is extracted by the root
        final int N = 100000;               //
        double[] q = new double[N];         // set array with "roots"
        for (int i = 0; i < N; i++){        //
            q[i] = Math.ceil(Math.sqrt(i)); //
        }
        System.out.println(sq(n, e, q[n])); // call method sq with number from this is extracted by the root (n), with accuracy (e) and with his "root" (q[n])
        System.out.println(Math.sqrt(n));
    }

    public static double sq(double y, double e, double x){
        double D;
        do {
            D = (y - x * x) / (2 * x);
            x += D;
        }while (Math.abs(D) > e);
        return x;
    }
}
