import java.util.*;

public class Q1790 {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long k = sc.nextLong();

        if (getSuccessiveNumberLength(N) < k) {
            System.out.println(-1);
            System.exit(0);
        }

        // 이분탐색
        int l = 1; int r = N; // k번째 숫자를 찾는데 k가 1부터 시작하므로 인덱스도 1부터 시작하게 둔다.
        int ans = 0;

        while(l <= r) {
            int mid = (l+r) / 2;
            long len = getSuccessiveNumberLength(mid);
            if (len < k) {
                l = mid + 1;
            } else {
                ans = mid;
                r = mid - 1;
            }
        }

        String s = Integer.toString(ans);
        long len = getSuccessiveNumberLength(ans);
        System.out.println(s.charAt(s.length()-(int)(len-k)-1));
    }

    private static long getSuccessiveNumberLength(int n) {
        long ans = 0;
        int len = 1;
        for (int start = 1; start <= n; start *= 10) {
            int end = start * 10 - 1;
            if (n < end) {
                ans += (n - start + 1) * len;
                break;
            }
            ans += (long) (end - start + 1) * len;
            len += 1;
        }
        return ans;
    }
}