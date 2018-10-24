import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.PriorityQueue;

// 하다 말았음
class Node {
    int s,e,v;
    public Node(int s, int e, int v) {
        this.s = s;
        this.e = e;
        this.v = v;
    }
}

public class Main {
    public static int N;
    public static int E;
    public static ArrayList<Node>[] nodeList;
    public static boolean visit[];
    public static int answer;
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answer = 0;
        N = Integer.valueOf(br.readLine()); // 정점의 갯수
        E = Integer.valueOf(br.readLine()); // 간선의 갯수
        visit = new boolean[N+1];
        nodeList = new ArrayList[N+1];

        for(int i = 1; i <= N; i++) {
            nodeList[i] = new ArrayList<Node>();
        }

        String[] temp;
        int start;
        int end;
        int value;

        for(int i = 0; i < E; i++) {
            temp = br.readLine().split(" ");
            start = Integer.valueOf(temp[0]);
            end = Integer.valueOf(temp[1]);
            value = Integer.valueOf(temp[2]);

            nodeList[start].add(new Node(start,end,value));
            nodeList[end].add(new Node(start,end,value));
        }

        MST();
        System.out.println();

    }

    public static void MST() {
        Comp cp = new Comp();

        PriorityQueue<Node> pq = new PriorityQueue<>(cp);
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(1);
        ArrayList<Node> tempList;
        Node tempNode;

        while(!dq.isEmpty()) {
            int currentNode = dq.poll();
            visit[curentNode] = true;
            tempList = nodeList[currentNode];
            //for(int i = 0; i<)
        }
    }
}

class Comp implements Comparator<Node> {
    @Override
    public int compare(Node n1, Node n2) {
        return n1.v > n2.v ? 1 : -1;
    }
}