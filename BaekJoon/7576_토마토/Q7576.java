import java.util.*;
import java.io.*;

public class Q7576 {
    static int row;
    static int col;
    static int[][] tomato;
    static int[] moveX = {0, -1, 0, 1};
    static int[] moveY = {-1, 0, 1, 0};
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] condition = br.readLine().split(" ");
        col = Integer.valueOf(condition[0]);
        row = Integer.valueOf(condition[1]);

        tomato = new int[row][col];

        Queue<Pos> q = new LinkedList<>();


        for (int i = 0; i < row; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < col; j++) {
                tomato[i][j] = Integer.parseInt(input[j]);
                if (tomato[i][j] == 1) {
                    q.add(new Pos(i, j));
                } 
            }
        }

        if (q.size() != 0) {
            while (!q.isEmpty()) {
                Pos polledPos = q.poll();
                int x = polledPos.x;
                int y = polledPos.y;

                for (int k = 0; k < 4; k++) {
                    int moveI = x + moveX[k];
                    int moveJ = y + moveY[k];

                    if (0 <= moveI && moveI < row && 0 <= moveJ && moveJ < col) {
                        if (tomato[moveI][moveJ] == 0) {
                            tomato[moveI][moveJ] = tomato[x][y] + 1;
                            q.add(new Pos(moveI, moveJ));
                        }
                    }
                }
            }
        } else {
            System.out.println(-1);
            System.exit(0);
        }

        int ans = -1;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(tomato[i][j] == 0) {
                    System.out.println(-1);
                    System.exit(0);
                }
                if (tomato[i][j] > ans) {
                    ans = tomato[i][j];
                }
            }
        }

        System.out.println(ans - 1);
    }
}

class Pos {
    int x;
    int y;
    
    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}