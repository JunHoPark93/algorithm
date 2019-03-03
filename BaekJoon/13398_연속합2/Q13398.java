import java.util.*;

public class Q13398 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        int[] left = new int[N];
        int[] right = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        left[0] = nums[0];
        // d[i]는 i를 마지막으로 하는 최대합
        for (int i = 1; i < N; i++) {
            left[i] = Math.max(nums[i], left[i-1] + nums[i]);
        }

        right[N-1] = nums[N-1];
        for (int i = N-2; i >= 0; i--) {
            right[i] = Math.max(nums[i], right[i+1] + nums[i]);
        }

        // 제거하지 않았을 때의 최댓 값 먼저 하나 구하고
        int max = -1001;
        for (int i = 0; i < N; i++) {
            if (left[i] > max) {
                max = left[i];
            }
        }

        // 수를 제거 했을 때의 최대 합 k라는 수를 제거 했으면 0~k-1까지, k+1 ~ N-1 까지
        // 그 k는 0부터 N-1까지 가능

        for (int k = 0; k < N; k++) {
            int temp;
            // 0 ~ k-1
            if (k == 0) {
                temp = right[N-2];
            } else if (k == N-1) {
                temp = left[N-2];
            } else {
                temp = left[k-1] + right[k+1];
            }
            if (max < temp) {
                max = temp;
            }
        }

        System.out.println(max);
    }
}