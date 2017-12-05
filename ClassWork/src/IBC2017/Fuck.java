package sawe;

import java.math.BigInteger;

/**
 * Project name: ClassWork
 * Created by pavel on 08.08.17.
 */

public class Fuck {

    /**
     * Основная формула вычисления количества наборов сокращается по правилам математики,
     * и в итоге мы, через сумму и разность логорифмов, находим количество разрядов -> количество цифр
     */
    public static void main(String[] args) {
        double sum1 = 0;
        for (int i = 1; i < 101; i++) {
            sum1 += Math.log10(i);
        }
        System.out.println((int) (Math.floor(sum1) + 1));

        int sum = 0;
        for (int i = 1; i <101; i++) {
            sum += Lo(i);
        }

        System.out.println(sum);

    }

    public static int Lo(double x){
        int digit = 0;
        while (x > 9){
            digit++;
            x /= 10;
        }
        return digit;
    }
}
