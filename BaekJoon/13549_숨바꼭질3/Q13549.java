import java.util.*;

public class Q13549 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int subin = sc.nextInt();
        int sister = sc.nextInt();

        boolean[] check = new boolean[1000000];
        int[] dist = new int[1000000];

        Queue<Integer> mainQ = new LinkedList<>();
        Queue<Integer> subQ = new LinkedList<>();

        mainQ.add(subin);
        check[subin] = true;
        dist[subin] = 0; // 현재 자기 자신의 위치

        while(true) {
            int temp = mainQ.poll();

            if (temp == sister) {
                break;
            }
            
            if (temp*2 <= 100000) {
                if (check[temp*2] == false) {
                    mainQ.add(temp*2);
                    check[temp*2] = true;
                    dist[temp*2] += dist[temp]; // 순간이동은 0초
                }
            }

            if (temp-1 >= 0) {
                if (check[temp-1] == false) {
                    subQ.add(temp-1);
                    check[temp-1] = true;
                    dist[temp-1] += dist[temp] + 1; // 1초 추가
                }
            }

            if (temp+1 <= 100000) {
                if (check[temp+1] == false) {
                    subQ.add(temp+1);
                    check[temp+1] = true;
                    dist[temp+1] += dist[temp] + 1; // 1초 추가
                }
            }

            if (mainQ.isEmpty()) {
                mainQ = subQ;
                subQ = new LinkedList();
            }
        }

        System.out.println(dist[sister]);
    }
}