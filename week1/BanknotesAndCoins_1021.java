import java.io.IOException;
import java.util.*;
public class BanknotesAndCoins_1021 {
    
    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(System.in);
        
        double d = sc.nextDouble() * 100;
        int n = (int)d;
        
        System.out.println("NOTAS:");
        System.out.println((n / 10000) + " nota(s) de R$ 100.00");
        n %= 10000;
        System.out.println((n / 5000) + " nota(s) de R$ 50.00");
        n %= 5000;
        System.out.println((n / 2000) + " nota(s) de R$ 20.00");
        n %= 2000;
        System.out.println((n / 1000) + " nota(s) de R$ 10.00");
        n %= 1000;
        System.out.println((n / 500) + " nota(s) de R$ 5.00");;
        n %= 500;
        System.out.println((n / 200) + " nota(s) de R$ 2.00");
        n %= 200;
        
        System.out.println("MOEDAS:");
        System.out.println((n / 100) + " moeda(s) de R$ 1.00");
        n %= 100;
        System.out.println((n / 50) + " moeda(s) de R$ 0.50");
        n %= 50;
        System.out.println((n / 25) + " moeda(s) de R$ 0.25");
        n %= 25;
        System.out.println((n / 10) + " moeda(s) de R$ 0.10");
        n %= 10;
        System.out.println((n / 5) + " moeda(s) de R$ 0.05");;
        n %= 5;
        System.out.println((n) + " moeda(s) de R$ 0.01");
        
    }
    
}