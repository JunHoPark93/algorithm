import java.util.*;

public class Q14442 {
    static int[] xMove = {-1, 0, 1, 0};
    static int[] yMove = {0, 1, 0, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();

        int maze[][] = new int[n+1][m+1];
        int dist[][][] = new int[n+1][m+1][k+1]; // 벽을 k 번 부쉈는지에 대한 필드 추가

        for (int i = 1; i <= n; i++) {
            String input = sc.nextLine();
            for (int j = 1; j <= m; j++) {
                maze[i][j] = input.charAt(j-1) - '0';
            }
        }

        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(1,1,0));

        dist[1][1][0] = 1; // 시작 점도 포함시킨다고 하였음

        while(!q.isEmpty()) {
            Pos cur = q.poll();
            int x = cur.x; int y = cur.y; int bomb = cur.bomb;

            for (int s = 0; s < 4; s++) {
                int towardX = x + xMove[s]; int towardY = y + yMove[s];
                
                if (1 <= towardX && towardX <= n && 1 <= towardY && towardY <= m) {
                    if (maze[towardX][towardY] == 1) { // 벽이라면
                        if (bomb < k && dist[towardX][towardY][bomb+1] == 0) { // 폭탄 갯수가 충분하고, 폭탄을 던져서 간적이 없다면
                            q.add(new Pos(towardX, towardY, bomb+1));
                            dist[towardX][towardY][bomb+1] = dist[x][y][bomb] + 1;
                        }
                    } else { // 벽이 아니라면
                        if (dist[towardX][towardY][bomb] == 0) { // 간 적이 없어야 함
                            q.add(new Pos(towardX, towardY, bomb));
                            dist[towardX][towardY][bomb] = dist[x][y][bomb] + 1;
                        }
                    }
                }
            }
        }

        int ans = 1000001;
        boolean flag = false;
        for (int i = 0; i <= k; i++) {
            if (dist[n][m][i] == 0) {
                continue;
            } else {
                flag = true;
                if (ans > dist[n][m][i]) {
                    ans = dist[n][m][i];
                }
            }
        }

        if (flag) {
            System.out.println(ans);
        } else {
            System.out.println(-1);
        }
    }
}

class Pos {
    int x; int y; int bomb;
    public Pos(int x, int y, int bomb) {
        this.x = x;
        this.y = y;
        this.bomb = bomb;
    }
}