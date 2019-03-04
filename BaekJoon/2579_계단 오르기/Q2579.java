import java.util.*;

public class Q2579 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] stairs = new int[N+1];
        int[] d = new int[N+1];

        for (int i = 1; i <= N; i++) {
            stairs[i] = sc.nextInt();
        }

        d[1] = stairs[1];
        d[2] = stairs[1] + stairs[2];

        // d[i]는 i 번째 계단을 밟았을 떄의 최대 점수
        // i-1을 밟던지 (이말은 i를 밟은 상황을 가정한 거니까 i-2는 밟지 않았어야 함), i-1을 밟지 않고 i-2를 밟고 왔던지
        for (int i = 3; i <= N; i++) {
            d[i] = Math.max(d[i-3] + stairs[i-1] + stairs[i], d[i-2] + stairs[i]);
        }

        System.out.println(d[N]);

    }
}