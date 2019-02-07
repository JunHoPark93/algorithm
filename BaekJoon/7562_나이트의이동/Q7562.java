import java.util.*;

public class Q7562 {
    // 나이트의 이동 경우의 수
    static int[] moveX = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] moveY = {-2, -1, 1, 2, 2, 1, -1, -2};
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 나이트 검사
        while (n-- > 0) {
            int line = sc.nextInt();
            int[][] chess = new int[line][line];
            boolean[][] check = new boolean[line][line];
            Queue<Pos> q = new LinkedList<>();

            int nowX = sc.nextInt();
            int nowY = sc.nextInt();

            //check[nowX][nowY] = true;
            q.add(new Pos(nowX, nowY));

            int goalX = sc.nextInt();
            int goalY = sc.nextInt();

            while(!q.isEmpty()) {
                Pos temp = q.poll();
                int curX = temp.x;
                int curY = temp.y;

                if (curX == goalX && curY == goalY) {
                    break;
                }

                for (int i = 0; i < 8; i++) {
                    int nextX = curX + moveX[i];
                    int nextY = curY + moveY[i];
                    if (0 <= nextX && nextX < line && 0 <= nextY && nextY < line) {
                        if (chess[nextX][nextY] == 0) {
                            q.add(new Pos(nextX, nextY));
                            chess[nextX][nextY] = chess[curX][curY] + 1;
                        }
                    }
                }
            }
            System.out.println(chess[goalX][goalY]);
        }

        // 출력
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