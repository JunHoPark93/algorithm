import java.util.*;

public class Q1890 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] game = new int[100][100];
        long[][] d = new long[100][100];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                game[i][j] = sc.nextInt();
            }
        }

        d[0][0] = 1;
        // d[i][j] : i행 j열 까지 오는 경우의 수
        // 위에서 오는 경우, 좌측에서 오는 경우 
        // 위에서 왔을 때
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                // 위
                for (int k = 0; k < i; k++) {
                    if (game[k][j] + k == i) {
                        d[i][j] += d[k][j];
                    }
                }

                // 왼쪽
                for (int k = 0; k < j; k++) {
                    if (game[i][k] + k == j) {
                        d[i][j] += d[i][k];
                    }
                }
            }
        }

        System.out.println(d[n-1][n-1]);
    }
}