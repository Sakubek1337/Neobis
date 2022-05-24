import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Grenais1131 {
 
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int inter = 0;
        int gremio = 0;
        int draws = 0;
        int inputs = 1;
        if(x == y){
            draws++;
        }else if(x > y){
            inter++;
        }else{
            gremio++;
        }
        System.out.println("Novo grenal (1-sim 2-nao)");
        int res = sc.nextInt();
        while(res == 1){
            inputs++;
            System.out.println("Novo grenal (1-sim 2-nao)");
            x = sc.nextInt();
            y = sc.nextInt();
            if(x == y){
                draws++;
            }else if(x > y){
                inter++;
            }else{
                gremio++;
            }
            res = sc.nextInt();
        }
        System.out.println(inputs + " grenais");
        System.out.println("Inter:" + inter);
        System.out.println("Gremio:" + gremio);
        System.out.println("Empates:" + draws);
        if(inter > gremio){
            System.out.println("Inter venceu mais");
        }else if(gremio > inter){
            System.out.println("Gremio venceu mais");
        }else{
            System.out.println("Não houve vencedor");
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