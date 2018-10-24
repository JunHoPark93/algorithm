import java.util.*;

// O(n*n) ...
class Solution {
    public int solution(int[] A) {
        int len = A.length;
        int cnt = 0;
        
        // 0 - > right, 1 - > left
        for(int i = 0; i < len; i++) {
            if(A[i] == 0) {
                for(int j = i; j < len; j++) {
                    if(A[j] == 1) {
                        cnt++;
                    }
                }
            } else if(A[i] == 1) {
                for(int j = 0; j < i; j++) {
                    if(A[j] == 0) {
                        cnt++;
                    }
                }
            }
        }
        
        return cnt/2;
    }
}