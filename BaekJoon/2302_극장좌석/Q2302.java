import java.util.*;

public class Q2302 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int seat = sc.nextInt();
        int vipNum = sc.nextInt(); 
        List<Integer> list = new ArrayList<>();
        
        list.add(0);
        while (vipNum-- > 0) {
            int vip = sc.nextInt();
            list.add(vip);
        }

        list.add(seat+1);
        
        int[] d = new int[41];
        d[0] = 1; d[1] = 1;
        for (int i = 2; i <= 40; i++) {
            d[i] = d[i-1] + d[i-2];
        }

        long answer = 1;
        for (int i = 0; i < list.size()-1; i++) {
            answer *= d[(list.get(i+1) - list.get(i)-1)];
        }

        System.out.println(answer);
    }
}