import java.util.*;

public class Q1717 {
    static int group[];
    public static void main(String[] arg) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int loop = sc.nextInt();
        
        group = new int[n+1];

        for (int i = 1; i <=n; i++) {
            group[i] = i;
        }

        // 0부터 시작하면 유니온 1이면 검사
        while(loop-- > 0) {
            int check = sc.nextInt();
            int parent = sc.nextInt();
            int child = sc.nextInt();
            if (check == 0) {
                union(parent, child);
            } else { 
                check(parent, child);
            }
        }
    }

    private static int findParent(int c) {
        if (group[c] == c) {
            return c;
        } else {
            return group[c] = findParent(group[c]); // 탐색하면서 중간 노드들도 부모를 바꾸어준다. 안하면 시간 초과 남
        }
    }

    private static void union(int p, int c) {
        int pParent = findParent(p);
        int cParent = findParent(c);
        group[cParent] = pParent;
    }

    private static void check(int p, int c) {
        if (findParent(p) == findParent(c)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}