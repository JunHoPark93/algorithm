import java.util.*;

public class Q11053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] numbers = new int[N];
        int[] d = new int[N]; // D[i]는 i에서 끝나는 가장 긴 증가하는 부분 수열의 길이

        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            d[i] = 1;
            for (int j = 0; j < i; j++) {
                if (numbers[j] < numbers[i] && d[i] < d[j] + 1) { // 일단 끝 부분이 더 커야하고, 여태 기록 된 값과 차례로 비교 한다
                    d[i] = d[j] + 1;
                }
            }
        }

        int max = 1;
        for (int i = 0; i < N; i++) {
            if (max < d[i]) {
                max = d[i];
            }
        }

        System.out.println(max);
    }
}