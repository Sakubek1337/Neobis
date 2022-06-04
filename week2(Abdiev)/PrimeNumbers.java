package lab;


import java.util.Scanner;

public class PrimeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tries = scanner.nextByte();
        int usInput;
        int zero;
        String x = "";
        while (tries--> 0) {
            usInput = scanner.nextInt();
            zero = 0;
            for (int e = 2;e < usInput;e++) {
                if (usInput % e == 0) zero++;
            }
            if (zero == 0) {
                x +=usInput + " eh primo\n";
            }
            else {
                x +=usInput + " nao eh primo\n";
            }
        }
        System.out.println(x);
    }
}
