import java.io.IOException;
import java.util.*;
public class TriangleTypes_1045 {
 
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        double[] arr = new double[3];
        arr[0] = sc.nextDouble();
        arr[1] = sc.nextDouble();
        arr[2] = sc.nextDouble();
        Arrays.sort(arr);
        double a = arr[2];
        double b = arr[1];
        double c = arr[0];
        if(a >= b + c){
            System.out.println("NAO FORMA TRIANGULO");
        }else{
            if(a * a == b * b + c * c){
                System.out.println("TRIANGULO RETANGULO");
            }else if(a * a > b * b + c * c){
                System.out.println("TRIANGULO OBTUSANGULO");
            }else if(a * a < b * b + c * c){
                System.out.println("TRIANGULO ACUTANGULO");
            }
            if(a == b && b == c){
                System.out.println("TRIANGULO EQUILATERO");
            }else if(a == b || b == c || c == a){
                System.out.println("TRIANGULO ISOSCELES");
            }
        }
    }
 
}