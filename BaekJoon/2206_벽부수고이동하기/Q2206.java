import java.util.*;
import java.io.*;

class Pair {
    int x;
    int y;
    int z;

    public Pair(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Q2206 {
    static int[] xMove = {-1, 0, 1, 0};
    static int[] yMove = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] condition = br.readLine().split(" ");
        int row = Integer.valueOf(condition[0]);
        int col = Integer.valueOf(condition[1]);

        int[][] wall = new int[row][col];
        int[][][] check = new int[row][col][2];

        for (int i = 0 ; i < row; i++) {
            String input = br.readLine();
            for (int j = 0; j < col; j++) {
                wall[i][j] = input.charAt(j) - '0';
            }
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0,0));
        check[0][0][0] = 1;

        while(!q.isEmpty()) {
            Pair temp = q.poll();

            int curX = temp.x;
            int curY = temp.y;
            int curZ = temp.z; // 부쉈는지 안 부쉈는지 체크

            for (int i = 0; i < 4; i++) {
                int moveX = curX + xMove[i]; int moveY = curY + yMove[i];

                if (0 <= moveX && moveX < row && 0 <= moveY && moveY < col) {
                    if (wall[moveX][moveY] == 0 && check[moveX][moveY][curZ] == 0) { // 벽이 아니라면 이동
                        q.add(new Pair(moveX, moveY, curZ));
                        check[moveX][moveY][curZ] = check[curX][curY][curZ] + 1;
                    }
                    
                    if (wall[moveX][moveY] == 1 && curZ == 0 && check[moveX][moveY][curZ] == 0) { // 벽 이고 아직 부수기 안 했으면
                        q.add(new Pair(moveX, moveY, curZ + 1));
                        check[moveX][moveY][curZ + 1] = check[curX][curY][curZ] + 1; // 부수기 씀
                    }
                }
            }
        }

        // 결과가 0이라면 갈 수가 없음
        if (check[row-1][col-1][0] != 0 && check[row-1][col-1][1] != 0) {
            System.out.println(Math.min(check[row-1][col-1][0], check[row-1][col-1][1]));
        } else if (check[row-1][col-1][0] != 0) {
            System.out.println(check[row-1][col-1][0]);
        } else if (check[row-1][col-1][1] != 0) {
            System.out.println(check[row-1][col-1][1]);
        } else {
            System.out.println(-1);
        }
    }
}