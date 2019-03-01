import java.util.*;

public class Q1965 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] boxes = new int[N];
        int[] d = new int[N];

        for (int i = 0; i < N; i++) {
            boxes[i] = sc.nextInt();
        }

        // d[i]는 i 번째 상자까지 겹쳐진 최대 상자 개수
        for (int i = 0; i < N; i++) {
            d[i] = 1; // 최악의 경우에는 겹칠 수 있는 상자가 없을 때 (아무것도 안겹쳐지면 자기 혼자 이므로 1)

            for (int j = 0; j < i; j++) {
                if (boxes[j] < boxes[i] && d[i] < d[j] + 1) { // j보단 i 가 크고, j보다 1증가한 (i가 기므로) 것이 그냥 i보다 크다면 최댓값을 업데이트 해준다
                    d[i] = d[j] + 1;
                }
            }
        }

        int max = 1;
        for (int i = 0; i < N; i++) {
            if (max < d[i]) {
                max = d[i];
            }
        }

        System.out.println(max);
    }
}