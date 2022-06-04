package lab;

import java.util.Scanner;

public class PerfectNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long z;
        int q;
        String res;
        byte r = scanner.nextByte();
        while (r --> 0) {
            z = scanner.nextLong();
            q = 0;
            for (int e = 1; e< z;e++) {
                if (z % e == 0) {
                    q+=e;
                }
            }
            res = q == z ? "eh perfeito" : "nao eh perfeito";
            System.out.println(z + " " + res);

        }
    }
}
