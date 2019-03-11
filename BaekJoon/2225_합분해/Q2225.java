import java.util.*;

public class Q2225 {
    static long mod = 1000000000L;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 0~n 까지
        int k = sc.nextInt(); // 정수 k개를 더하는 것

        // d[n][k] : 0 ~ n 까지의 정수 k개를 더해서 합이 n이 되는 경우의 수
        long[][] d = new long[n+1][k+1];
        //d[0][0] = 1;
        //d[1][1] = 1; 
        for (int i = 0; i <= n; i++) {
            d[i][1] = 1;
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                for (int m = 0; m <= i; m++) {
                    d[i][j] += d[i-m][j-1];
                    d[i][j] %= mod;
                }
            }
        }

        System.out.println(d[n][k]);
    }
}