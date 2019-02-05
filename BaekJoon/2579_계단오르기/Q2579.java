import java.util.*;
import java.io.*;

public class Q2579 {
    public static void main(String[] args) {
        // 계단 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] step = new int[n+1];
        int[] d = new int[n+1];

        for (int i = 1; i <= n; i++) {
            step[i] = sc.nextInt();
        }

        d[1] = step[1];
        d[2] = step[1] + step[2];
        // 계단 최댓값 - D[i]는 i번째 계단에 올랐을 때 최대 점수
        for (int i = 3; i <= n; i++) {
            d[i] = Math.max(d[i-3] + step[i-1] + step[i], d[i-2] + step[i]);
        }

        // 출력
        System.out.println(d[n]);
    }
}