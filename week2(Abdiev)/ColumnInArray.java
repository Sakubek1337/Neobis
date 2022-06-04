package lab;

import java.util.Scanner;

public class ColumnInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] columns = new double[12][12];
        int columnNumb = sc.nextInt();
        String indicator = sc.next();
        double x = 0;
        if (columnNumb <= 11 && columnNumb >= 0) {
            for (int i = 0; i < columns.length; i++) {
                for (int j = 0; j < columns.length; j++) {
                    columns[i][j] = sc.nextFloat();
                    if (columnNumb == j) {
                        x += columns[i][j];
                    }
                }
            }
            if ("M".equals(indicator)) {
                System.out.printf("%.1f\n", (x / 12));
            } else if ("S".equals(indicator)) {
                System.out.printf("%.1f\n", x);
            }
        }
    }
}
