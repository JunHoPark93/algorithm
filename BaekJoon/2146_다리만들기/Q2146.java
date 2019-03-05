import java.util.*;

public class Q2146 {
    static int[] moveX = {-1, 0, 1, 0};
    static int[] moveY = {0, 1, 0, -1};
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        int[][] group = new int[n][n];
        int[][] dist = new int[n][n];
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                group[i][j] = 0;
                dist[i][j] = -1;
            }
            sc.nextLine();
        }

        Queue<Pos> q = new LinkedList<>();
        int count = 0;
        // dfs로 땅 구분 (1,2,3 ...)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && group[i][j] == 0) {
                    q.add(new Pos(i, j));
                    ++count;
                    group[i][j] += count;

                    while (!q.isEmpty()) {
                        Pos temp = q.poll();
                        int x = temp.x;
                        int y = temp.y;
                        for (int k = 0; k < 4; k++) {
                            int towardX = x + moveX[k];
                            int towardY = y + moveY[k]; 
                            if (0 <= towardX && towardX < n && 0 <= towardY && towardY < n) {
                                if (map[towardX][towardY] == 1 && group[towardX][towardY] == 0) {
                                    q.add(new Pos(towardX, towardY));
                                    group[towardX][towardY] += count;
                                }
                            }
                        }
                    }
                }
            }
        }

        Queue<Pos> distQ = new LinkedList<>(); 

        int ans = -1;
        for (int cnt = 1; cnt <= count; cnt++) { // 각 그룹에 대해서 실시
            distQ = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = -1;
                    if (group[i][j] == cnt) {
                        distQ.add(new Pos(i, j));
                        dist[i][j] = 0;
                    }
                }
            }

            while (!distQ.isEmpty()) {
                Pos temp = distQ.poll();
                int x = temp.x;
                int y = temp.y;
    
                for (int k = 0; k < 4; k++) {
                    int towardX = x + moveX[k]; 
                    int towardY = y + moveY[k];
    
                    if (0 <= towardX && towardX < n && 0 <= towardY && towardY < n) {
                        if (dist[towardX][towardY] == -1) {
                            distQ.add(new Pos(towardX, towardY));
                            dist[towardX][towardY] = dist[x][y] + 1;
                        }
                    }
                }
            }

            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (map[i][j] == 1 && group[i][j] != cnt) { // 땅이 있고, 그 땅의 그룹이 자기자신이 아니면
                        if (ans == -1 || dist[i][j]-1 < ans) { 
                            ans = dist[i][j]-1;
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }
}

class Pos {
    int x; int y;
    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}