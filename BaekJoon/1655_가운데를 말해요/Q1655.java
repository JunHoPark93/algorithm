import java.util.*;

public class Q1655 {
    static class Compare implements Comparator<Integer> {
        public int compare(Integer n1, Integer n2) {
            return n2.compareTo(n1);
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Compare());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        maxHeap.add(sc.nextInt()); // for문안의 로직을 줄이기 위해서 먼저 하나 넣었음 (문제의 조건에도 1개이상 들어옴)
        System.out.println(maxHeap.peek());

        for (int i = 2; i <= n; i++) {
            int input = sc.nextInt();
            
            if (input <= maxHeap.peek()) {
                maxHeap.add(input);
            } else {
                minHeap.add(input);
            }

            int diff = maxHeap.size() - minHeap.size();

            if (diff > 1) {
                int move = maxHeap.poll();
                minHeap.add(move);
            } else if (diff <= -1) {
                int move = minHeap.poll();
                maxHeap.add(move);
            }

            System.out.println(maxHeap.peek());
        }
    }
}
