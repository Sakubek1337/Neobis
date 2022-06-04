package lab;

import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        String first;
        String second;
        String max;
        String zero;
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            first = scanner.nextLine();
            second = scanner.nextLine();
            if (first.length() >= second.length()) {
                max = first;
                zero = second;
            } else {
                max = second;
                zero = first;
            }
            int minLen = zero.length();
            int maxString = minLen;
            boolean f = true;
            while (maxString > 0 && f) {
                int diff = minLen - maxString;
                for (int i = 0; i <= diff; i++) {
                    if (max.contains(zero.substring(i, i + maxString))) {
                        f = false;
                        maxString++;
                        break;
                    }
                }
                maxString--;
            }
            System.out.println(maxString);
        }
    }
}
