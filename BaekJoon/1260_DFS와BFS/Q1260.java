import java.util.*;
import java.io.*;

public class Q1260 {
    private static int[][] node;
    private static int[] checkBfs;
    private static int[] checkDfs;
    private static Queue<Integer> queue = new LinkedList<>();
    private static int v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        v = Integer.valueOf(line[0]); 
        int e = Integer.valueOf(line[1]); 
        int startNode = Integer.valueOf(line[2]);

        node = new int[v+1][v+1];
        checkDfs = new int[v+1];
        checkBfs = new int[v+1];

        for(int i = 1; i<= e; i++) {
            String[] input = br.readLine().split(" ");
            int node1 = Integer.valueOf(input[0]);
            int node2 = Integer.valueOf(input[1]);

            node[node1][node2] = 1;
        }

        dfs(startNode);
        System.out.println();
        bfs(startNode);
    }

    private static void dfs(int n) {
        System.out.print(n + " ");
        checkDfs[n] = 1;
        for(int i = 1; i <= v; i++) {
            if(checkDfs[i] == 0 && node[n][i] == 1){
                dfs(i);
            }
        }
    }

    private static void bfs(int n) {
        queue.add(n); checkBfs[n] = 1;
        while(!queue.isEmpty()) {
            int currentNode = queue.peek();
            queue.poll();
            System.out.print(currentNode + " ");
            for(int i = 0; i <= v; i++) {
                if(node[currentNode][i] == 1 && checkBfs[i] == 0) {
                    queue.add(i);
                    checkBfs[i] = 1;
                }
            }
        }
    }
}
