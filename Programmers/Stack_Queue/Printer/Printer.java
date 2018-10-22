import java.util.*;

public class Printer {
    public static void main(String[] args) {
        int answer = 0;
        int idx = 0;

        int[] priorities = {1,1,9,1,1,1};
        int location = 0;

        // pq is an actual printer
        Queue<Integer> pq = new PriorityQueue<>(priorities.length, (a,b) -> { return b - a; });
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
            q.add(priorities[i]);
        }

        while(!pq.isEmpty()) {
            // print if same
            if(pq.peek() == q.peek()) {
                answer++;
                pq.remove();
                q.add(q.peek());
                q.remove();

                if(idx%priorities.length == location) {
                    break;
                }
                idx++;
            } else {
                q.add(q.peek()); // move front val to end
                q.remove();
                idx++;
            }

        }

        System.out.println(answer);

    }
}