package lab;


import java.util.Scanner;

public class PasswordsValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String w;
        int length;
        int numb;
        int upLet;
        int lowLet;
        while (scanner.hasNext()) {
            w = scanner.nextLine();
            length = w.length();
            lowLet = 0;
            numb = 0;
            upLet = 0;
            if (length >= 6 && length <= 30) {
                for (int y = 0;y < length;y++) {
                    if (w.charAt(y) >= 'a' && w.charAt(y) <= 'z') lowLet++;
                    else if (w.charAt(y) >= 'A' && w.charAt(y) <= 'Z') upLet++;
                    else if (w.charAt(y) >= '0' && w.charAt(y) <= '9') numb++;
                }

                if (lowLet == 0) System.out.println("Senha invalida.");
                else if (upLet == 0) System.out.println("Senha invalida.");
                else if (numb == 0) System.out.println("Senha invalida.");
                else if (lowLet + upLet + numb == length) System.out.println("Senha valida.");
                else System.out.println("Senha invalida.");
            }
            else {
                System.out.println("Senha invalida.");
            }
        }
    }
}
