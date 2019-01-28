import java.util.*;
import java.io.*;

public class Q4963 {
    static boolean[][] check;
    static int[][] map;
    static int[] xPos = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] yPos = {-1, 0 , 1, 1, 1, 0, -1, -1};
    public static void main(String[] args) throws IOException {
        // 입력을 구분
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] condition = br.readLine().split(" ");
            int col = Integer.valueOf(condition[0]);
            int row = Integer.valueOf(condition[1]);

            if (col == 0 && row == 0) {
                break;
            }

            map = new int[row][col];
            check = new boolean[row][col];

            for (int i = 0; i < row; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < col; j++) {
                    map[i][j] = Integer.valueOf(input[j]);
                }
            }
    
            int count = 0;
    
            // 섬 탐색
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (map[i][j] == 1 && check[i][j] == false) {
                        findLandWithDFS(i, j, row, col);
                        count++;
                    }
                }
            }
            System.out.println(count);    
        };
    }

    private static void findLandWithDFS(int x, int y, int row, int col) {
        // 사방비교
        check[x][y] = true;
        for (int i = 0; i < 8; i++) {
            int moveI = x + xPos[i];
            int moveJ = y + yPos[i];

            // 재귀탐색
            if (0 <= moveI && moveI < row && 0 <= moveJ && moveJ < col) {
                if (check[moveI][moveJ] == false && map[moveI][moveJ] == 1) {
                    findLandWithDFS(moveI, moveJ, row, col);
                }
            }
        }
    }
}