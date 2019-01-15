import java.util.*;

public class Q9465 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while(n-- > 0) {
            int col = sc.nextInt();
            int[][] a = new int[3][col+1];
            int[][] d = new int[col+1][3];

            for (int i = 1; i <= col; i++) {
                a[1][i] = sc.nextInt();
            }

            for (int i = 1; i <= col; i++) {
                a[2][i] = sc.nextInt();
            }
            
            for (int i = 1; i <= col; i++) {
                d[i][0] = max(d[i-1][1], max(d[i-1][2], d[i-1][0]));
                d[i][1] = max(d[i-1][0], d[i-1][2]) + a[1][i];
                d[i][2] = max(d[i-1][0], d[i-1][1]) + a[2][i];
            }

            System.out.println(max(d[col][0], max(d[col][1], d[col][2])));
        }
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }

    // private static int max(int a, int b, int c) {
    //     return a > b ? (a > c ? a : c) : (b > c ? b : c);
    // }
}