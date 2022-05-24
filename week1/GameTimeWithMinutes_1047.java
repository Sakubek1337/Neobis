import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class GameTimeWithMinutes_1047 {
 
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int h = sc.nextInt();
        int m = sc.nextInt();
        int h2 = sc.nextInt();
        int m2 = sc.nextInt();
        int dh, dm;
        if(m > m2){
            h2--;
            m2 += 60;
        }
        dm = m2 - m;
        if(h > h2){
            h2 += 24;
        }
        dh = h2 - h;
        if(dh == 0 && dm == 0){
            dh = 24;
        }
        System.out.println("O JOGO DUROU " + dh + " HORA(S) E " + dm + " MINUTO(S)");
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