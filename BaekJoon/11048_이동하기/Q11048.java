import java.util.*;
import java.io.*;

public class Q11048 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.valueOf(input[0]);
        int m = Integer.valueOf(input[1]);
        int[][] candy = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                candy[i][j] = Integer.valueOf(line[j-1]);
            }
        }

        int[][] d = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=m; j++) {
                d[i][j] = Math.max(Math.max(d[i-1][j], d[i-1][j-1]), d[i][j-1]) + candy[i][j];
            }
        }

        System.out.println(d[n][m]);
    }
}