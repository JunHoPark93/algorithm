import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int v = sc.nextInt();
        // int e = sc.nextInt();
        // int start = sc.nextInt();


        // int a[][] = new int[v+1][v+1];
        // for(int i = 1; i <= e; i++) {
        //     int x = sc.nextInt();
        //     int y = sc.nextInt();
        //     a[x][y] = 1;
        //     a[y][x] = 1;
        // }

        // int[] check = new int[v+1];
        // for(int c : check) {
        //     System.out.print(c + " ");
        // }

        // test case
        int v = 4;
        int start = 1;

        int[][] a = {{0,0,0,0,0}, {0,0,1,1,1}, {0,1,0,0,1}, {0,1,0,0,1}, {0,1,1,1,0}};
        int[] check = new int[v+1];

        DFS(a, check, start);

        check = new int[v+1];
        System.out.println();

        BFS(a, check, start);

    }

    public static void DFS(int[][] a, int[] check, int vertex) {
        System.out.print(vertex + " ");
        check[vertex] = 1;

        for(int i = 1; i < a[0].length; i++) {

            if(a[vertex][i] == 1 && check[i] == 0) {
                DFS(a, check, i);
            }
        }
    }

    public static void BFS(int[][] a, int[] check, int vertex) {
        Queue<Integer> q = new LinkedList();

        check[vertex] = 1;
        q.add(vertex);

        System.out.print(vertex + " ");

        while(!q.isEmpty()) {
            int temp = q.poll();

            for(int i = 1; i < a[0].length; i++) {
                if(a[temp][i] == 1 && check[i] == 0) {
                    check[i] = 1;
                    q.add(i);
                    System.out.print(i + " ");
                }
            }
        }
    }
}
