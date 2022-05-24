import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class SequenceIJ4_1098 {
 
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int i = 0;
        while(i <= 20){
            if(i % 10 == 0){
                System.out.println("I=" + (i / 10) + " J=" + ((i + 10) / 10));
                System.out.println("I=" + (i / 10) + " J=" + ((i + 20) / 10));
                System.out.println("I=" + (i / 10) + " J=" + ((i + 30) / 10));
            }else{
                System.out.println("I=" + ((double)i / 10) + " J=" + ((double)(i + 10) / 10));
                System.out.println("I=" + ((double)i / 10) + " J=" + ((double)(i + 20) / 10));
                System.out.println("I=" + ((double)i / 10) + " J=" + ((double)(i + 30) / 10));
            }
            
            i += 2;
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