package lab;


import java.util.Scanner;

public class HAHHAHHA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String pusto = "";
        for (int r = 0;r < input.length();r++) {
            if (input.charAt(r) == 'a' || input.charAt(r) == 'e' || input.charAt(r) == 'u' || input.charAt(r) == 'i' || input.charAt(r) == 'o' ) pusto+=input.charAt(r);
        }
        String result = pusto.contentEquals(new StringBuilder(pusto).reverse()) ? "S" : "N";
        System.out.println(result);
    }
}
