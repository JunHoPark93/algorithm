import java.util.*;
import java.io.*;

public class Q2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.valueOf(br.readLine());

        int[] glasses = new int[length+1];
        int[][] d = new int[length+1][3];

        for(int i = 1; i <= length; i++) {
            glasses[i] = Integer.valueOf(br.readLine());
        }

        d[1][0] = 0; d[1][1] = glasses[1]; d[1][2] = glasses[1];

        for(int i = 2; i <= length; i++) {
            d[i][0] = Math.max(Math.max(d[i-1][1], d[i-1][2]), d[i-1][0]);
            d[i][1] = d[i-1][0] + glasses[i];
            d[i][2] = d[i-2][0] + glasses[i-1] + glasses[i];
        }

        int ans = Math.max(Math.max(d[length][0], d[length][1]), d[length][2]);

        System.out.println(ans);
    }
}