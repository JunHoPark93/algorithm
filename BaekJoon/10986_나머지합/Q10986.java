import java.util.*;

public class Q10986 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] nums = new int[N];
        long[] d = new long[N];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        d[0] = nums[0];

        for (int i = 1; i < N; i++) {
            d[i] = d[i-1] + nums[i];
        }

        // d[i]는 0~i구간 의 합
        // from ~ to 구간의 합 d[to] - d[from] + nums[from]
        // 1 <= from <= N, from <= to <= N (다 비교하면 N제곱... N제한에 걸려서 안됨)
        // (d[to] - d[from] + nums[from]) % M == 0 인 갯수를 찾는 것

        // 혹은 (d[to] - d[from-1]) % M == 0
        // d[to] % M = d[from-1] % M 인경우!!
        
        // M으로 나누어 떨어지는 수를 인덱스로 하는 배열 cnt
        long[] cnt = new long[M];
        
        for (int i = 0; i < N; i++) {
            cnt[(int)(d[i] % M)] += 1;
        }

        long ans = 0;
        for (int i = 0; i < M; i++) {
            ans += cnt[i] * (cnt[i]-1) / 2; // 조합의 수 nCm 을 나타냄
        }

        ans += cnt[0]; // 0으로 나누어 떨어지는 수 더하기 (조합이 i,j가 아니라 i,i 같은 수가 나올 수 있기 때문에 얘네들만 더해준다)

        System.out.println(ans);
    }
}