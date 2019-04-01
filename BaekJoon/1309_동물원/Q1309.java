import java.util.*;

public class Q1309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] d = new long[n+1][3];

        // d[i][j] : 2 * i 크기에서 j번째 사자를 넣었을 때 사자를 배치하는 경우의 수
        d[1][0] = 1;
        d[1][1] = 1;
        d[1][2] = 1;
        
        for (int i = 2; i <= n; i++) {
            d[i][0] = d[i-1][0] + d[i-1][1] + d[i-1][2];
            d[i][1] = d[i-1][0] + d[i-1][2];
            d[i][2] = d[i-1][0] + d[i-1][1];
            for (int j = 0; j < 3; j++) {
                d[i][j] %= 9901;
            }
        }

        System.out.println((d[n][0] + d[n][1] + d[n][2])%9901);
    }
}