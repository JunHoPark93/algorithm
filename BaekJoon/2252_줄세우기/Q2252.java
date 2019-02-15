import java.util.*;

public class Q2252 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] inDegree = new int[N+1];
        Queue<Integer> q = new LinkedList<>();
        
        List<Integer> lists[] = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            int small = sc.nextInt();
            int big = sc.nextInt();
            inDegree[big] += 1; // 큰 아이
            lists[small].add(big);
        }

        for (int i = 1; i < N+1; i++) {
            if (inDegree[i] == 0) { 
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int temp = q.poll();
            System.out.print(temp + " ");

            for (int i = 0; i < lists[temp].size(); i++) {
                // 하나 뺐으니까 indegree 1 감소
                int curInDegree = inDegree[lists[temp].get(i)] -= 1;

                // inDegree가 0 이라면 큐에 넣는다
                if (curInDegree == 0) {
                    q.add(lists[temp].get(i));
                }
            }
        }

    }
}