import java.util.*;
import java.io.*;

public class Q2667_sol3 {
    static int[] xMove = {-1, 0, 1, 0};
    static int[] yMove = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String condition = br.readLine();
        int n = Integer.valueOf(condition);
        int[][] complex = new int[n][n];
        boolean[][] check = new boolean[n][n];
        Queue<Pair> q = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                complex[i][j] = input.charAt(j) - '0';
                complex[i][j] *= -1;
            }
        }
        int count = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (check[i][j] == false && complex[i][j] == -1) { // 집이 있으면
                    q.add(new Pair(i,j));
                    check[i][j] = true;
                    count++; // 아파트 단지 수 추가 
                    hashMap.put(count, 1);     
                    while (!q.isEmpty()) {
                        Pair pair = q.poll();

                        for (int k = 0; k < 4; k++) {
                            int towardX = pair.x + xMove[k];
                            int towardY = pair.y + yMove[k];

                            if (0 <= towardX && towardX < n && 0 <= towardY && towardY < n) {
                                if (complex[towardX][towardY] == -1 && check[towardX][towardY] == false) {
                                    q.add(new Pair(towardX, towardY));
                                    complex[towardX][towardY] = count;
                                    check[towardX][towardY] = true;
                                    hashMap.put(count, hashMap.get(count) + 1);
                                }
                            }
                        }
                    }
                }
            }
        }
        List<Integer> answer = new ArrayList<>();
        System.out.println(count);

        for (Map.Entry<Integer, Integer> i : hashMap.entrySet()) {
            answer.add(i.getValue());
        }

        Collections.sort(answer);
        answer.stream().forEach(System.out::println);
    }
}

class Pair {
    int x;
    int y;
    public Pair (int x, int y) {
        this.x = x;
        this.y = y;
    }
}
