package sawe; /**
 * Created by pavel on 03.08.17.
 */
import java.io.*;
import java.math.*;

import static java.lang.System.out;

public class CW {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        out.printf("Введите число a (a ≠ 0) - ");
        int a = Integer.parseInt(reader.readLine());

        out.printf("Введите число b - ");
        int b = Integer.parseInt(reader.readLine());

        out.printf("Введите число c - ");
        int c = Integer.parseInt(reader.readLine());

        out.printf("Введите число e - ");
        double e = Integer.parseInt(reader.readLine());

        int D = b*b-(4*a*c);

        if(D < 0)
        {
            out.println("Корней нет! Ничего считать не надо!");
        }
        else if (D == 0)
        {
            out.println("Есть ровно один корень!");

            double x = -b/2*a;

            out.printf("И мы его нашли x = %s", x);
        }
        else if(D > 0)
        {
            out.println("Корней будет два!");

            double d = D;
            double x = 1;
            for (;;) {
                double nx = (x + d / x) / 2;
                if (Math.abs(x - nx) < e)  break;
                x = nx;
            }

            double x1 = (-b+x)/2*a;
            int i1 = (int) x1;
            double x2 = (-b-x)/2*a;
            int i2 = (int) x2;

            out.printf("И мы их нашли x(1) = %s и x(2) = %s", i1, i2);
        }

    }

}
