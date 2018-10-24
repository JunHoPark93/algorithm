import java.util.*;

class Solution {
    public int solution(int[] A) {        
        int len = A.length;
        int answer = 0;
        
        Arrays.sort(A);
        
        for(int i = 0; i < len; i++) {
            if(A[i] == i+1)
                continue;
            else {
                answer = i+1;
                break;
            }
        }
        
        return answer;
    }
}