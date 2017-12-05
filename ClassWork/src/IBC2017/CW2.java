package sawe;

/**
 * Project name: ClassWork
 * Created by pavel on 09.08.17.
 */

class Fib {
    public int sum = 0;
    int fib(int n) {
        sum++;
        if(n == 1){return 1;}
        if(n == 0){return 0;}
        else {return fib(n - 1) + fib(n - 2);}
    }
}

class Recursion {
    public static void main(String args [ ]) {
        long start = System.currentTimeMillis();
        Fib f = new Fib ();
        for (int i = 0; i <= 40; i++) {
            System.out.println(i + " fib: " + f.fib(i));
        }

        long timeWorkCode = System.currentTimeMillis() - start;
        System.out.println("Program run-time is " + timeWorkCode + " milisecond(s)");
        System.out.println("f.fib call times: " + f.sum);
    }
}