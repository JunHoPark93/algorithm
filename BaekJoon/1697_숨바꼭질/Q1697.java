import java.util.*;

public class Q1697 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int subinLocation = sc.nextInt();
        int brotherLocation = sc.nextInt();
        int MAX_NUM = 1000000;
        Queue<Integer> q = new LinkedList<>();
        boolean[] check = new boolean[MAX_NUM];
        int[] dist = new int[MAX_NUM];

        q.add(subinLocation);
        dist[subinLocation] = 0;
        check[subinLocation] = true;

        while (!q.isEmpty()) {
            int n = q.poll();
        
            if (n-1 >= 0 && check[n-1] == false) {
                q.add(n-1);
                check[n-1] = true;
                dist[n-1] = dist[n] + 1;
            }

            if (n+1 < MAX_NUM && check[n+1] == false) {
                q.add(n+1);
                check[n+1] = true;
                dist[n+1] = dist[n] + 1;
            }

            if (2*n < MAX_NUM && check[2*n] == false) {
                q.add(2*n);
                check[2*n] = true;
                dist[2*n] = dist[n] + 1;
            }
        }

        System.out.println(dist[brotherLocation]);
    }
}