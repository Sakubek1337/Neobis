package lab;

import java.util.Scanner;

public class Fib {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tries;
        int nFib;
        long[] fibArray = new long[80];
        tries = scanner.nextInt();

        fibArray[0] = 0;
        fibArray[1] = 1;
        for(int j = 2; j <= 79; j++){
            fibArray[j] = fibArray[j-2] + fibArray[j-1];
        }

        while (tries --> 0) {
            nFib = scanner.nextInt();
            System.out.printf("Fib(%d) = %d\n", nFib, fibArray[nFib]);
        }
    }
}
