import java.util.*;
/**
 *  Bottom up 방식
 */
public class Q1463_sol2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] D = new int[n+1];

        D[1] = 0;

        for (int i = 2; i <= n; i++) {
            D[i] = D[i-1] + 1;

            if (i % 2 == 0 && D[i/2] + 1 < D[i]) {
                D[i] = D[i/2] + 1;
            }

            if (i % 3 ==0 && D[i/3] + 1 < D[i]) {
                D[i] = D[i/3] + 1;
            }
        }

        System.out.println(D[n]);
    }
}