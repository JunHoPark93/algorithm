import java.util.*;

public class Main {
    public static void main(String[] args) {
        int answer = 1;
        Scanner sc = new Scanner(System.in);

        int tot = sc.nextInt();
        sc.nextLine();
        int vipNum = sc.nextInt();
        sc.nextLine();

        int[] fib = new int[tot+1];
        fib[0] = fib[1] = 1;

        for(int i = 2; i <= tot; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }

        int temp = 0;
        for(int i = 0; i < vipNum; i++) {
            int vip = sc.nextInt();
            sc.nextLine();

            answer = answer * fib[vip - temp - 1];
            temp = vip;
        }

        answer = answer * fib[tot - temp];

        System.out.println(answer);
    }
}