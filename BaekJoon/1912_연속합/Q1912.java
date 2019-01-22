import java.util.*;
import java.io.*;

public class Q1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());
        int[] num = new int[n];
        String[] str = br.readLine().split(" ");
        int len = str.length;

        int[] d = new int[n];

        for(int i = 0; i < len; i++) {
            num[i] = Integer.valueOf(str[i]);
        }

        d[0] = num[0];

        for(int i = 1; i < n; i++) {
            if(d[i-1] + num[i] > num[i]) {
                d[i] = d[i-1] + num[i];
            } else{
                d[i] = num[i];
            }
        }
        
        int ans = d[0];

        for(int i = 1; i < n; i++) {
            if(ans < d[i]) {
                ans = d[i];
            }
        }    

        System.out.println(ans);
    }

}