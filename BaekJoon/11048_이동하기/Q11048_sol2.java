import java.util.*;
import java.io.*;

/*
* 재귀를 이용한 풀이
*/
public class Q11048_sol2 {
    static int[][] d;
    static int[][] candy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.valueOf(line[0]);
        int m = Integer.valueOf(line[1]);

        candy = new int[n+1][m+1];
        d = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                candy[i][j] = Integer.valueOf(input[j-1]);
                d[i][j] = -1;
            }
        }

        System.out.println(go(n,m));
    }

    private static int go(int i, int j) {
        if (i < 1 || j < 1) return 0;

        if (d[i][j] >= 0) return d[i][j];

        d[i][j] = Math.max(go(i-1, j), go(i, j-1)) + candy[i][j];
        return d[i][j];
    }
}