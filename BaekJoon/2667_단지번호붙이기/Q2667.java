import java.util.*;
import java.io.*;

public class Q2667 {

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
                    dfs(i, j, ++count);
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

        System.out.println(count);
        for (int num : buidingNumOfComplex) {
            System.out.println(num);
        }
    }

    private static void dfs(int i, int j, int count) {
        complex[i][j] = count;
        int moveI; int moveJ;
        for (int k = 0; k < 4; k++) {
            moveI = i + row[k];
            moveJ = j + col[k];

            if (0 <= moveI && moveI < n && 0 <= moveJ && moveJ < n) {
                if (complex[moveI][moveJ] == 0 && building[moveI][moveJ] == 1) {
                    dfs(moveI, moveJ, count);
                }
            }
        }
    }
}