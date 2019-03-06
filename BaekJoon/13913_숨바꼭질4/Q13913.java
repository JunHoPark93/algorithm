import java.util.*;

public class Q13913 {
    static final int MAX = 1000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] result = new int[MAX];
        boolean[] check = new boolean[MAX];
        int[] from = new int[MAX];

        result[N] = 0;
        check[N] = true;

        Queue<Integer> q = new LinkedList<>();
        q.add(N); // 수빈이의 처음 위치를 넣는다

        while(!q.isEmpty()) {
            int cur = q.poll();

            if (cur + 1 < MAX && check[cur + 1] == false ) {
                q.add(cur + 1);
                check[cur + 1] = true;
                result[cur + 1] = result[cur] + 1;
                from[cur + 1] = cur;
            }

            if (0 <= cur - 1 && check[cur - 1] == false) {
                q.add(cur - 1);
                check[cur - 1] = true;
                result[cur - 1] = result[cur] + 1;
                from[cur - 1] = cur;
            }

            if (cur * 2 < MAX && check[cur * 2] == false) {
                q.add(cur * 2);
                check[cur * 2] = true;
                result[cur * 2] = result[cur] + 1;
                from[cur * 2] = cur;
            }
        }

        System.out.println(result[K]);

        print(N, K, from);
        System.out.println();
    }

    private static void print(int N, int K, int[] from) {
        if (N != K) {
            print(N, from[K], from);
        }
        System.out.print(K + " ");
    }
}