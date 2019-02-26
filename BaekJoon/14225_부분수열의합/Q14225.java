import java.util.*;

public class Q14225 {
    static boolean[] number = new boolean[2000001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] input = new int[N];

        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }

        go(input, 0, 0,  N);

        int answer = 1;
        for (int i = 0; i < number.length; i++) {
            if (number[i] == false) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }

    private static void go(int[] input, int sum, int index, int max) {
        if (index == max) {
            number[sum] = true;
            return;
        }

        if (index > max) {
            return;
        }

        go(input, sum + input[index], index+1, max);
        go(input, sum, index+1, max);
    }
}