import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int glass = sc.nextInt();
        
        int[] w = new int[glass+1];
        int[] dp = new int[glass+1];


        for(int i = 1; i < glass + 1; i++) {
            w[i] = sc.nextInt();
        }

        if(glass == 1) {
            System.out.println(w[1]);
            return;
        }

        dp[1] = w[1];
        dp[2] = w[1] + w[2];

        for(int i = 3; i < glass + 1; i++) {
            dp[i] = max(dp[i-2] + w[i], dp[i-3] + w[i-1] + w[i]);
            dp[i] = max(dp[i], dp[i-1]);
        }
        
        System.out.println(dp[glass]);
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }
}