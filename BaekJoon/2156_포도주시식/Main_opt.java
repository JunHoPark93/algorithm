import java.util.*;

public class Main_opt {

    public static int Max(int a, int b, int c) {
        if(b > c) {
            if(a > b) return a;
            else return b;

        } else {
            if(a > c) return a;
            else return c;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int d[] = new int[10001];
        int a[] = new int[10001];

        for(int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        d[0] = 0; d[1] = a[1];
        d[2] = d[1] + a[2];

        for(int i = 3; i <= n; i++) {
            d[i] = Max(d[i-3] + a[i-1] + a[i], d[i-2] + a[i], d[i-1]);
        }

        System.out.println(d[n]);
    }
}