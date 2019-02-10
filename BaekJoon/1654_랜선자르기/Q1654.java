import java.util.*;

public class Q1654 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt(); // 이미 가지고 있는 랜선의 갯수
        int N = sc.nextInt(); /// 필요한 랜선의 갯수
        long[] lan = new long[K];

        for (int i = 0; i < K; i++) {
            lan[i] = sc.nextLong();
        }

        Arrays.sort(lan);

        long x = lan[K-1]; // 제일 큰 길이의 랜선을 가진다.
        long left = 1; long right = x;
        long ans = 0;

        while (left <= right) {
            int sum = 0;
            long mid = (left + right) / 2;

            for (int i = 0; i < K; i++) {
                sum += (lan[i] / mid);
            }

            if (sum < N) { // N개 미만으로 잘림 -> 잘리는 x를 줄여야 함
                right = mid - 1;
            } else { // N개 이상으로 잘림 -> 잘리는 x를 크게해야 함
                ans = mid;
                left = mid + 1;
            }
        }

        System.out.println(ans);
    }
}