import java.util.*;

public class Q11659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        sc.nextLine();

        int[] nums = new int[N+1];

        for (int i = 1; i <= N; i++) {
            nums[i] = sc.nextInt();
        }

        int[] d = new int[N+1]; // d[i]는 0 부터 i까지의 합

        for (int i = 1; i <= N; i++) {
            d[i] = d[i-1] + nums[i];
        }

        // M 번의 입력
        while (M-- > 0) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            sc.nextLine();

            System.out.println(d[to] - d[from] + nums[from]);
        }
    }
}