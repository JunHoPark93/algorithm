import java.util.*;
public class Q14002 {
    static int[] temp;
    static int[] numbers;
    static int[] d;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        numbers = new int[N];
        d = new int[N]; // D[i]는 i에서 끝나는 가장 긴 증가하는 부분 수열의 길이
        temp = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            d[i] = 1;
            temp[i] = -1;
            for (int j = 0; j < i; j++) {
                if (numbers[j] < numbers[i] && d[i] < d[j] + 1) { // 일단 끝 부분이 더 커야하고, 여태 기록 된 값과 차례로 비교 한다
                    d[i] = d[j] + 1;
                    temp[i] = j; // i가 되기 전 마지막으로 더해진 최댓 값의 인덱스
                }
            }
        }

        int max = 1;
        int maxIdx = 0;
        for (int i = 0; i < N; i++) {
            if (max < d[i]) {
                max = d[i];
                maxIdx = i;
            }
        }

        System.out.println(max);
        print(maxIdx);
    }

    private static void print(int index) {
        if (index == -1) return;
        print(temp[index]);
        System.out.print(numbers[index]+ " ");
    }
}