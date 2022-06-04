package lab;


import java.util.Scanner;

public class Caesar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        short tries = scanner.nextShort();
        char [] input;
        byte shift;
        String q;
        String y = "";
        while (tries --> 0 ) {
            input = scanner.next().toCharArray();
            shift = scanner.nextByte();
            q ="";
            for (char c : input) {
                char e = (char) (c - shift);
                if (e < 65) {
                    e+=26;
                }
                q+=e;
            }
            y+=q+"\n";
        }
        System.out.print(y);
    }
}
