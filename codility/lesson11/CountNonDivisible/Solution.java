import java.util.*;

class Solution {
    public int solution(int[] A) {
        int len = A.length;
        int[] d = new int[len];
        int ans = 0;
        
        d[0] = A[0];
        
        for (int i = 1; i < len; i++) {
            d[i] = d[i-1];
            for (int j = 1; j <= Math.min(i, 6); j++) {
                d[i] = Math.max(d[i], d[i-j]);
            }
            d[i] += A[i];
        }
        return d[len-1];
    }
}