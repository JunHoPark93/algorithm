import java.util.*;

public class Q10844 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[][] d = new long[n+1][10];

        for (int i = 1; i <= 9; i++) {
            d[1][i] = 1;
        }
        
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    d[i][j] += d[i-1][j+1];
                    d[i][j] %= 1000000000;
                    continue;
                }
                if (j == 9) {
                    d[i][j] += d[i-1][j-1];
                    d[i][j] %= 1000000000;
                    continue;
                }
                d[i][j] = d[i-1][j+1] + d[i-1][j-1];
                d[i][j] %= 1000000000;
            }
        }
        long sum = 0;

        for(int i = 0; i <= 9; i++) {
            sum += d[n][i];
        }
        System.out.println(sum % 1000000000);
    }
}