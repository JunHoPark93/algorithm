import java.util.*;

public class DFS_BFS_Practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int v = sc.nextInt();
        int e = sc.nextInt();
        int start = sc.nextInt();

        int x,y;

        int[][] a = new int[v+1][v+1]; // 노드시작을 1로 결정
        boolean[] checked = new boolean[v+1]; // 전부 FALSE로 초기화  

        // 인접행렬 초기화
        for(int i = 0; i < e; i++) {
            x = sc.nextInt();
            y = sc.nextInt();

            a[x][y] = 1;
            a[y][x] = 1;
        }

        DFS(a, checked, start);
        checked = new boolean[v+1];
        System.out.println();
        BFS(a, checked, start);

    }

    public static void DFS(int[][] a, boolean[] checked, int vertex) {
        System.out.print(vertex + " ");
        checked[vertex] = true;
        for(int i = 1; i < a[0].length; i++) {
            // 도달 가능하고 방문하지 않았다면
            if(a[vertex][i] == 1 && checked[i] == false) {
                DFS(a, checked, i);
            }
        }
    }

    public static void BFS(int[][] a, boolean[] checked, int vertex) {
        Queue<Integer> q = new LinkedList();
        q.add(vertex);
        checked[vertex] = true;
        System.out.print(vertex + " ");
        
        while(!q.isEmpty()) {
            int temp = q.poll();
            for(int i = 1; i < a[0].length; i++) {
                if(a[temp][i] == 1 && checked[i] == false) {
                    checked[i] = true;
                    q.add(i);
                    System.out.print(i + " ");
                }
            }
        }
    }
}

