import java.util.*;

public class Q1260_opt {
    static ArrayList<Integer>[] a;
    static boolean[] check;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt();

        a = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            a[n1].add(n2);
            a[n2].add(n1);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(a[i]);
        }

        check = new boolean[n+1];
        dfs(start);
        System.out.println();
        check = new boolean[n+1];
        bfs(start);
    }

    private static void dfs(int n) {
        check[n] = true;
        System.out.print(n + " ");
        
        for (int x : a[n]) {
            if (check[x] == false) {
                dfs(x);
            }
        }
    }

    private static void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        check[n] = true;

        while(!q.isEmpty()) {
            int node = q.peek();
            q.poll();
            System.out.print(node + " ");
           
            for (int x : a[n]) {
                if(check[x] == false) {
                    q.add(x);
                    check[x] = true;
                }
            }
        }
    }
}