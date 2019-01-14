import java.util.*;

public class Q11057 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] d = new int[1001][10];

        for(int i = 0; i <= 9; i++) {
            d[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                for(int k = 0; k <= j; k++) {
                    d[i][j] += d[i-1][k];
                }
                d[i][j] %= 10007;
            }
        }

        int sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum += d[n][i];
        }

        System.out.println(sum %= 10007);
    }
}