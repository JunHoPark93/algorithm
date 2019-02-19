import java.util.*;
import java.io.*;

public class Q1922 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine()); // 컴퓨터의 수
        int M = Integer.valueOf(br.readLine()); // 연결할 수 있는 선의 수
        boolean[] check = new boolean[N+1];
        int sum = 0;

        ArrayList<NodeDetail>[] list = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            String[] input = br.readLine().split(" ");
            int from = Integer.valueOf(input[0]);
            int to = Integer.valueOf(input[1]);
            int value = Integer.valueOf(input[2]);

            list[from].add(new NodeDetail(from, to, value));
            list[to].add(new NodeDetail(to, from, value));            
        }

        // 최소 비용 계산 - MST 최소 비용 신장트리를 이용 한다
        PriorityQueue<NodeDetail> pQueue = new PriorityQueue<>();

        for (NodeDetail nodeDetail : list[1]) {
            pQueue.add(nodeDetail);
        }

        check[1] = true;

        while (!pQueue.isEmpty()) {
            NodeDetail temp = pQueue.poll();

            if(check[temp.to] == false) {
                sum += temp.value;
                check[temp.to] = true;
                for (int i = 0; i < list[temp.to].size(); i++) {
                    pQueue.add(list[temp.to].get(i));
                }
            }
        }
        System.out.println(sum);
    }
}
class NodeDetail implements Comparable<NodeDetail> {
    int from;
    int to;
    int value;
    public NodeDetail(int from, int to, int value) {
        this.from = from;
        this.to = to;
        this.value = value;
    }
    public int compareTo(NodeDetail input) {
        if (this.value < input.value) {
            return -1;
        } else if (this.value == input.value) {
            return 0;
        } else {
            return 1;
        }
    }
}