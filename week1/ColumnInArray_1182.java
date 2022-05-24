import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class ColumnInArray_1182 {
 
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int column = sc.nextInt();
        String op = sc.nextLine();
        int[][] arr = new int[12][12];
        int sum = 0;
        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 12; j++){
                int temp = (int)(sc.nextDouble() * 10);
                arr[i][j] = temp;
            }
        }
        for(int i = 0; i < 12; i++){
            sum += arr[i][column];
        }
        if(op.equals("S")){
            System.out.println((double)sum / 10.0);
        }else{
            System.out.println((double)(sum / 12) / 10.0);
        }
    }
    
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
  
        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }
  
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
  
        int nextInt() { return Integer.parseInt(next()); }
  
        long nextLong() { return Long.parseLong(next()); }
  
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
  
        String nextLine()
        {
            String str = "";
            try {
                if(st.hasMoreTokens()){
                    str = st.nextToken("\n");
                }
                else{
                    str = br.readLine();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
 
}