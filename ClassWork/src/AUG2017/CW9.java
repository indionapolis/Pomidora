package AUG2017;

/**
 * Project name: ClassWork
 * Created by pavel on 22.08.17.
 */
public class CW9 {
    public static int d = 0;
    public static void main(String[] args) {
        System.out.println(F(50));
        System.out.println(d);
    }
    static int C(int n){
        d++;
        int r = 0;
        for (int i = 0; i < (1 << n); i++) {
            r += i;
        }
        return r;
    }

    static int F(int n){
        d++;
        if (n == 0) return 1;
        if (n == 1) return 1;
        else return F(n -1) + F(n - 2);
    }
}
