import java.util.*;

public class Q11052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] card = new int[n+1];
        int[] d = new int[n+1];

        for (int i = 1; i <= n; i++) {
            card[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if(d[i] < card[j] + d[i-j]) {
                    d[i] = card[j] + d[i-j];
                }
            }
        }   

        System.out.println(d[n]);
    }
}