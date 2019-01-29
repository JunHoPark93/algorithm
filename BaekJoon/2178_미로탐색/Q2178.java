import java.util.*;

public class Q2178 {
    static int[][] maze;
    static boolean[][] check;
    static int[] xMove = {-1, 0, 1, 0};
    static int[] yMove = {0, 1, 0, -1};
    static int row;
    static int col;
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        row = sc.nextInt();
        col = sc.nextInt();
        maze = new int[row+1][col+1];
        check = new boolean[row+1][col+1];

        sc.nextLine();

        for (int i = 1; i <= row; i++) {
            String input = sc.nextLine();
            for (int j = 1; j <= col; j++) {
                maze[i][j] = input.charAt(j-1) - '0';
            }
        }

        // 최소 경로 탐색 bfs
        findWayInMazeWithBFS(1,1);
    }

    private static void findWayInMazeWithBFS(int i, int j) {
        Queue<Pos> queue = new LinkedList<>();
        Pos p = new Pos(i,j);
        queue.add(p);
        check[i][j] = true;

        while(!queue.isEmpty()) {
            Pos polledPos = queue.poll();
            int x = polledPos.x;
            int y = polledPos.y;

            if (x == row && y == col) {
                System.out.println(maze[x][y]);
                break;
            }
            
            for (int k = 0; k < 4; k++) {
                int moveI = x + xMove[k];
                int moveJ = y + yMove[k];

                if (1 <= moveI && moveI <= row && 1 <= moveJ && moveJ <= col) {
                    if (check[moveI][moveJ] == false && maze[moveI][moveJ] == 1) {
                        queue.add(new Pos(moveI, moveJ));
                        maze[moveI][moveJ] += maze[x][y]; // 기존 미로를 계속 갱신 해야 함
                        check[moveI][moveJ] = true;
                    }
                }
            }
        }
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