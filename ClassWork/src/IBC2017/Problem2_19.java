package sawe;

public class Problem2_19 {
    private double[] intSqrt;

    public Problem2_19(int k) {
        this.intSqrt = new double[k];
        for (int i = 0; i < k; i++){
            this.intSqrt[i] = Math.ceil(Math.sqrt(i));
        }
    }

    /**
     * Algorithm of finding square root
     *
     * @param y number for which we are finding square root
     * @param eps accuracy of the solution
     * @return
     */
    public double getSqrt(int y, double eps) {
        double D = intSqrt[y];
        double x = y;
        do {
            D = (y - x * x) / (2 * x);
            x += D;
        }while (Math.abs(D) > eps);
        return x;
    }
}
