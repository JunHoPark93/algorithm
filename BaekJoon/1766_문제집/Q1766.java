import java.util.*;
import java.io.*;

public class Q1766 {
    public static void main(String[] args) throws IOException {
        // 입력
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] condition = br.readLine().split(" ");
        int N = Integer.valueOf(condition[0]);
        int M = Integer.valueOf(condition[1]);

        List<Integer>[] lists = new ArrayList[N+1];
        int inDegree[] = new int[N+1];
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            String[] input = br.readLine().split(" ");
            int former = Integer.valueOf(input[0]);
            int latter = Integer.valueOf(input[1]);
            
            inDegree[latter] += 1;
            lists[former].add(latter);
        }

        // 초기 시작 문제 들 큐에 삽입
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                pQueue.add(i);
            }
        }

        // 위상정렬 수행 : 우선순위는 낮은 수부터! 우선순위 큐 이용
        while (!pQueue.isEmpty()) {
            int temp = pQueue.poll();
            System.out.print(temp + " ");

            for(int i = 0; i < lists[temp].size(); i++) {
                inDegree[lists[temp].get(i)] -= 1;
                if (inDegree[lists[temp].get(i)] == 0) {
                    pQueue.add(lists[temp].get(i));
                }
            }
        }
    }
}