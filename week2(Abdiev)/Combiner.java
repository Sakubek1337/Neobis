package lab;


import java.util.Scanner;

public class Combiner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tries = scanner.nextInt();
        String first ;
        String second ;
        String pusto ;
        StringBuilder stringBuilder = new StringBuilder();
        while (tries --> 0) {
            pusto = "";
            first = scanner.next();
            second = scanner.next();
            int whilee = Math.min(first.length(),second.length());
            for (int r = 0;r < whilee;r++) {
                pusto += first.charAt(r);
                pusto += second.charAt(r);
            }
            if (second.length() > first.length()) pusto+= second.substring(first.length(),second.length());
            else pusto+= first.substring(second.length(),first.length());
            stringBuilder.append(pusto).append("\n");
        }
        System.out.print(stringBuilder);
    }
}
