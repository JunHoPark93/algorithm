import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] check = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (check[i] == false) {
                dfs(i, check, computers, n);
                answer++;
            }
        }
        return answer;
    }
    
    private void dfs(int node, boolean[] check, int[][] computers, int n) {
        check[node] = true;
        for (int i = 0; i < n; i++) {
            if (computers[node][i] == 1 && check[i] == false) {
                dfs(i, check, computers,n);
            }
        }
    }
}