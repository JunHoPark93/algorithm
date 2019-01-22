import java.util.*;
import java.io.*;

/**
 * 재귀 함수 솔루션
 */
public class Q9095_sol2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        while (n-- > 0) {
            int num = sc.nextInt();
            System.out.println(go(0,num));
        }
    }

    private static int go(int n, int goal) {
        if (n == goal) {
            return 1;
        }

        if (n > goal) {
            return 0;
        }

        int now = 0;
        for (int i = 1; i <= 3; i++) {
            now += go(n+i, goal);
        }
        return now;
    }
}