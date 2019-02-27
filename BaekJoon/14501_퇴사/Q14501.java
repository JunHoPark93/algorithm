import java.util.*;
public class Q14501 {
    static int max = 0;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        int[] p = new int[N+1];
        int[] t = new int[N+1];

        sc.nextLine();

        for (int i = 1; i <= N; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
            sc.nextLine();
        }

        // for (int i = 1; i <= N; i++) {
        //     System.out.print(t[i] + " ");
        //     System.out.print(p[i] + " ");
        //     System.out.println();
        // }

        go(p,t,0,1);

        System.out.println(max);
    }

    private static void go(int[] p, int[] t, int sum, int index) {
        if (index == N+1) {
            if (sum > max) {
                max = sum;
            }
            return;
        }
        if (index > N+1) {
            return;
        }

        go(p, t, sum, index+1);
        go(p, t, sum+p[index], index+t[index]);
    }
}