import java.util.*;

public class Main {
    private static int num;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        num = sc.nextInt();

        discern(1,2);
        discern(1,3);
        discern(1,5);
        discern(1,7);
    }

    private static void discern(int cnt, int n) {
        if(cnt == num) {
            if(isPrime(n)) 
                System.out.println(n);
            return;
        }

        for(int i = 1; i <= 9 ; i++) {
            if(isPrime(n*10 + i)) {
                discern(cnt+1, n*10 + i);
            }
        }
    }

    private static boolean isPrime(int n){
        if (n == 1)
            return false;
        for(int i = 2; i <= n/2; i++) {
            if(n%i == 0)  
                return false;
        }
        return true;
    }
}