import java.util.*;

public class Q2133 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n+1];
        d[0] = 1; // 없는 경우도 1
        for (int i = 2; i <= n; i+=2) {
            d[i] = d[i-2] * 3;
            for (int j = i-4; j >= 0; j-=2) {
                d[i] += d[j] * 2;
            }
        }

        System.out.println(d[n]);
    }
}