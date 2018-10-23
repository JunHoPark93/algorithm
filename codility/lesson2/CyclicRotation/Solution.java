import java.util.*;

class Solution {
    public int[] solution(int[] A, int K) {
        
        int len = A.length;
        if(K >= len) {
            K = len % K;
        }
        
        int[] answer = new int[len];

        if(K != 0) {
            K = K - 1;
        }

        for(int i = 0; i < len; i++) {
            if(i + K >= len) {
                answer[i] = A[(i+K) % len];
            } else {
                answer[i] = A[i+K];
            }
        }
        return answer;
    }
}