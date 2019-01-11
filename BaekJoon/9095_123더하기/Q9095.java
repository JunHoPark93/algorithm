import java.util.*;

public class Q9095 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] d = new int[11];
        d[0] = 1; d[1] = 1; d[2] = 2;
        for (int i = 3; i <= 10; i++) {
            d[i] = d[i-1] + d[i-2] + d[i-3];
        }

        int n = sc.nextInt();

        while (n-- > 0) {
            int num = sc.nextInt();
            System.out.println(d[num]);
        }
    }
} 