import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class PopulationIncrease1160 {
 
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int tests = sc.nextInt();
        while(tests-- > 0){
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            double perx = sc.nextDouble() / 100;
            int firstx = x;
            double pery = sc.nextDouble() / 100;
            int firsty = y;
            int tries = 0;
            while(tries < 100 && x <= y){
                x += (int)((double)x * perx);
                y += (int)((double)y * pery);
                tries++;
            }
            if(tries == 100 && x < y){
                System.out.println("Mais de 1 seculo.");
            }else{
                System.out.println(tries + " anos.");
            }
                
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