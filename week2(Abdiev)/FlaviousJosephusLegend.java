package lab;

import java.util.Scanner;

public class FlaviousJosephusLegend {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        byte r = scanner.nextByte();
        short cases = 1;
        int e;
        short q;
        int winner;
        while (r -->0) {
            e = scanner.nextInt();
            q = scanner.nextShort();
            winner = 2 * (e - (2*q)) +1;
            System.out.println(winner);
            stringBuilder.append("Case ").append(cases++).append(": ").append(winner).append("\n");
        }
        System.out.print(stringBuilder);
    }
}
