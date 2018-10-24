import java.util.*;

// linear search for test

class Solution {
    public int solution(int[] A) {
        int len = A.length;
        boolean[] checked = new boolean[len+1];
        
        for(int i = 0; i < len; i++) {
            for(int j = 1; j < len + 1; j++) {
                if(A[i] == j) {
                    checked[j] = true;
                } 
            }
        }
        
        int answer = 0;
        for(int i = 1; i < len + 1; i++) {
            if(checked[i] == false) {
                answer = i;
            }
        }
        
        return answer;
    }
}