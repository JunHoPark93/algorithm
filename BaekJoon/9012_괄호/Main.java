import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while(n-- >  0) {
            String s = sc.next();

            int cnt = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    cnt++;
                } else {
                    cnt--;
                }
    
                if (cnt < 0) {
                    break;
                }
            }
    
            if (cnt == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}