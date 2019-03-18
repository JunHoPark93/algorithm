import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] scoville = {1, 2};
        int K = 7;
        System.out.println(s.solution(scoville, K));
    }
}

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq =  new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {
            pq.offer(scoville[i]);
        }

        while (pq.size() > 1) {
            if (pq.peek() > K) {
                return answer;
            }
            int first = pq.poll();
            int second = pq.poll();

            int temp = first + (second * 2);
            pq.offer(temp);
            answer++;
        }

        if (pq.peek() >= K) {
            return answer;
        } else {
            return -1;
        }
    }
}