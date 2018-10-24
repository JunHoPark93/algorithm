import java.util.*;

class Solution {
    public int solution(int[] A) {        
        int len = A.length;
        int sum = (len + 2) * (len + 1) / 2;
        
        for(int i = 0; i < len; i++) {
            sum = sum - A[i];
        }
        
        return sum;
    }
}