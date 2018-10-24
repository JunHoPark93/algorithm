import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int v;
        int e;
        int INF = 1000000000;

        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();

        sc.nextLine();

        int[][] dist = new int[v+1][v+1]; // since it starts with number one vertex
        
        // initialize
        for(int i = 1; i < v+1; i++) {
            for(int j = 1; j < v+1; j++) {
                dist[i][j] = (i==j) ? 0 : INF;
            }
        }

        for(int i = 0; i < e; i++) {
            String str = sc.nextLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            dist[start][end] = val;
          
        }

        for(int k = 1; k < v+1; k++) {
            for(int i = 1; i < v+1; i++) {
                for(int j = 1; j < v+1; j++) {
                    if(dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        

        int min = 99999;
        int[] minIarr = new int[v+1];
        int[] minJarr = new int[v+1];
        //int[] result = new int[v+1];
        int result = INF;
        // find min value
        for(int i = 1; i < v+1; i++) {
            for(int j = 1; j < v+1; j++) {
                if(i == j) {
                    continue;
                }
            
                if(dist[i][j] < min) {
                    min = dist[i][j];
                }
            }
        }

        // find min value index and then find return path
        for(int i = 1; i < v+1; i++) {
            for(int j = 1; j < v+1; j++) {
                if(dist[i][j] == min && result >= min + dist[j][i]) {
                    result = min + dist[j][i];
                }
            }
        }

        if(result >= INF) {
            System.out.println("-1");
        } else {
            System.out.println(result);
        }
    }
}