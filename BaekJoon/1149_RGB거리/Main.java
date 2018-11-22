import java.util.*;

public class Main {
    public static void main(String[] args) {
        int rgb[][] = new int[1000][3];
        int dp[][] = new int [1000][3];

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            rgb[i][0] = sc.nextInt();
            rgb[i][1] = sc.nextInt();
            rgb[i][2] = sc.nextInt();
        }

        dp[0][0] = rgb[0][0];
        dp[0][1] = rgb[0][1];
        dp[0][2] = rgb[0][2];

        for(int i = 1; i < n; i++) {
            dp[i][0] = min(dp[i-1][1], dp[i-1][2]) + rgb[i][0];
            dp[i][1] = min(dp[i-1][0], dp[i-1][2]) + rgb[i][1];
            dp[i][2] = min(dp[i-1][1], dp[i-1][0]) + rgb[i][2];
        }

        int answer = min(dp[n-1][2], min(dp[n-1][0], dp[n-1][1]));

        System.out.println(answer);
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }
}