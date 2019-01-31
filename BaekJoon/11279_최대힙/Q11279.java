import java.util.*;

public class Q11279 {
    static int[] heap = new int[100001];
    static int index = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while (n-- > 0) {
            int input = sc.nextInt();
            
            if (input == 0) {
                // 최대값 반환
                if (index == 0) {
                    System.out.println(0);
                } else {
                    System.out.println(pop());
                }
            } else {
                push(input);
            }
        }
    }

    public static void push(int n) {
        heap[++index] = n;
        // 정렬
        for (int i = index; i > 1; i /= 2) {
            if (heap[i] > heap[i/2]) {
                int temp = heap[i]; heap[i] = heap[i/2]; heap[i/2] = temp;
            } else {
                break;
            }
        }
    }

    public static int pop() {
        int max = heap[1];
        heap[1] = heap[index];
        heap[index--] = 0;

        for (int i = 1; i*2 <= index; ) {
            if (heap[i] > heap[i*2] && heap[i] > heap[i*2+1]) {
                break;
            } else if (heap[i*2] > heap[i*2+1]) {
                int temp = heap[i]; heap[i] = heap[i*2]; heap[i*2] = temp;
                i = i*2;
            } else {
                int temp = heap[i]; heap[i] = heap[i*2+1]; heap[i*2+1] = temp;
                i = i*2 + 1;
            }
        }
        return max;
    }
}