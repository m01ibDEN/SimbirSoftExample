package utils;

import java.time.LocalDate;

public class Arithmetic {
    public static int fibonacciCalc() {
        LocalDate currentDate = LocalDate.now();
        int num = currentDate.getDayOfMonth() + 1;
        int fib = 1;
        int prevFib = 0;

        for (int i = 1; i < num; i++) {
            int temp = fib;
            fib += prevFib;
            prevFib = temp;
        }
        return fib;
    }
}
