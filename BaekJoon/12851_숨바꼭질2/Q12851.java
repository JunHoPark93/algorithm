import java.util.*;

public class Q12851 {
    private static int MAX = 1000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int subin = sc.nextInt();
        int sister = sc.nextInt();
        boolean[] check = new boolean[MAX];
        int[] dist = new int[MAX];
        int[] cnt = new int[MAX];

        Queue<Integer> q = new LinkedList<>();
        q.add(subin); // 수빈이의 위치 등록
        check[subin] = true;
        cnt[subin] = 1;
        dist[subin] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (0 <= cur - 1) {
                if (check[cur-1] == false) {
                    q.add(cur-1);
                    check[cur-1] = true;
                    dist[cur-1] = dist[cur] + 1; // 1초 추가
                    cnt[cur-1] = cnt[cur];
                } else if (dist[cur-1] == dist[cur] + 1){
                    cnt[cur-1] += cnt[cur];
                }
            }
            if (cur + 1 < MAX) {
                if (check[cur+1] == false) {
                    q.add(cur+1);
                    check[cur+1] = true;
                    dist[cur+1] = dist[cur] + 1; // 1초 추가
                    cnt[cur+1] = cnt[cur];
                } else if (dist[cur+1] == dist[cur] + 1){
                    cnt[cur+1] += cnt[cur];
                }
            }
            if (2*cur < MAX) {
                if (check[2*cur] == false) {
                    q.add(2*cur);
                    check[2*cur] = true;
                    dist[2*cur] = dist[cur] + 1; // 1초 추가
                    cnt[2*cur] = cnt[cur];
                } else if (dist[2*cur] == dist[cur] + 1) {
                    cnt[2*cur] += cnt[cur];
                }
            }
        }

        System.out.println(dist[sister]);
        System.out.println(cnt[sister]);
    }
}