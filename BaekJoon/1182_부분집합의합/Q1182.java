import java.util.*;


public class Q1182 {
    static int count = 0;
    static int N;
    static int S;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        S = sc.nextInt();

        int[] input = new int[N];

        sc.nextLine();

        for (int i = 0 ; i < N; i++) {
            input[i] = sc.nextInt();
        }

        int sum = 0;
        List<Integer> list = new ArrayList<>();
        go(input, sum, 0, list);

        System.out.println(count);
    }

    private static void go(int[] input, int sum, int index, List<Integer> list) {
        if (index == N && list.size() != 0) {
            if (sum == S) {
                count++;
            }
            return;
        }

        if (index > N-1) {
            return;
        }

        go(input, sum, index + 1, list);
        list.add(input[index]);
        go(input, sum + input[index], index + 1, list);
    }
}