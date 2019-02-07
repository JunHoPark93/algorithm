import java.util.*;


public class Q1699 {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d[] = new int[n+1];
        d[1] = 1;

        // 최소 값 계산 D[i] : i를 제곱수의 합으로 나타내었을 때 최소 갯수
        // 1로 끝나는경우, 2제곱으로 끝나는 경우, 3제곱으로 끝나는 경우
        // i-1, i-4, i-9 ... i-n의 제곱
        // j의 제곱이 i를 넘으면 안된다. 
        for (int i = 1; i <= n; i++) {
            int temp = 100000000;
            for (int j = 1; j*j <= i; j++) {
                if (temp > d[i - j*j]) {
                    temp = d[i - j*j];
                }
            }
            d[i] = temp + 1;
        }
        // 출력
        System.out.println(d[n]);
    }
}