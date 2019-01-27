import java.util.*;
import java.io.*;

public class Q2667_sol2 {
    static int n;
    static int[][] building;
    static int[][] complex;
    static int[] row = {0,-1,0,1};
    static int[] col = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.valueOf(br.readLine());
        building = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                building[i][j] = line.charAt(j) - '0';
            }
        }

        complex = new int[n][n];
        int count = 0;

        // 단지수 구하기 알고리즘
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(building[i][j] == 1 && complex[i][j] == 0) {
                    bfs(i, j, ++count);
                }
            }
        }
        // 문제에 맞게 출력
        int[] buidingNumOfComplex = new int[count];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (complex[i][j] != 0) {
                    buidingNumOfComplex[complex[i][j] - 1] ++;
                }
            }
        }
        
        Arrays.sort(buidingNumOfComplex);
        
        System.out.println(count);
        for (int num : buidingNumOfComplex) {
            System.out.println(num);
        }
    }

    private static void bfs(int i, int j, int count) {
        Queue<Pair> q = new LinkedList<>();
        int moveI; int moveJ;
        Pair startPair = new Pair(i,j);
        q.add(startPair);
        complex[i][j] = count;

        while (!q.isEmpty()) {
            Pair pulledP = q.poll();
            int x = pulledP.x;
            int y = pulledP.y;
            
            for (int k = 0; k < 4; k++) {
                moveI = x + row[k];
                moveJ = y + col[k];
                if (0 <= moveI && moveI < n && 0 <= moveJ && moveJ < n) {
                    if (complex[moveI][moveJ] == 0 && building[moveI][moveJ] == 1) {
                        Pair p = new Pair(moveI, moveJ);
                        q.add(p);
                        complex[moveI][moveJ] = count;
                    }
                }
            }
        }    
    }
}

class Pair {
    int x;
    int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}