import java.util.*;

public class Q5014 {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int f = sc.nextInt(); // 전체 건물 높이
        int s = sc.nextInt(); // 현재 층
        int g = sc.nextInt(); // 목표 층
        int u = sc.nextInt();
        int d = sc.nextInt();

        boolean[] check = new boolean[f+1]; // 건물 방문했는지 체크
        int[] dist = new int[f+1]; // 얼마나 걸리는지 값 기록하는 배열

        Queue<Integer> q = new LinkedList<>();
        q.add(s);  // 현재 위치
        dist[s] = 0; check[s] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();

            int up = cur + u;
            int down = cur - d;

            if (up <= f) {
                if (check[up] == false) {
                    q.add(up);
                    check[up] = true;
                    dist[up] = dist[cur] + 1;
                }
            }

            if (1 <= down) {
                if (check[down] == false) {
                    q.add(down);
                    check[down] = true;
                    dist[down] = dist[cur] + 1;
                }
            }
        }

        if (check[g]) {
            System.out.println(dist[g]);
        } else {
            System.out.println("use the stairs");
        }
    }
}