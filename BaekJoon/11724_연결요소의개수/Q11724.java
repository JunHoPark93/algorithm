import java.util.*;
import java.io.*;

public class Q11724 {
    static ArrayList<Integer>[] a;
    static boolean[] checked;
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputLines = br.readLine().split(" ");
        int v = Integer.valueOf(inputLines[0]);
        int e = Integer.valueOf(inputLines[1]);
        a = new ArrayList[v+1];
        checked = new boolean[v+1]; checked[0] = true;

        for (int i = 1; i <= v; i++) {
            a[i] = new ArrayList<>();
        }

        for(int i = 0; i < e; i++) {
            String[] inputs = br.readLine().split(" ");
            int n1 = Integer.valueOf(inputs[0]);
            int n2 = Integer.valueOf(inputs[1]);

            a[n1].add(n2);
            a[n2].add(n1);
        }

        // 모두 checked될 때가지 탐색을 돌린다. cnt 증가
        int cnt = 0;
        bfs(1);
        cnt ++;

        for(int i = 2; i <= v; i++) {
            if(checked[i] == false) {
                bfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static void bfs(int n) {
        Queue<Integer> q = new LinkedList();
        checked[n] = true;
        q.add(n);

        while(!q.isEmpty()) {
            int node = q.peek();
            q.poll();
            
            for(int x : a[node]) {
                if(checked[x] == false){
                    q.add(x);
                    checked[x] = true;
                }
            }
        }
    }
}