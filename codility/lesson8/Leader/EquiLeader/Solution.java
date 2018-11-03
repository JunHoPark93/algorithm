// you can also use imports, for example:
import java.util.*;

// 수정중.......
class Solution {
    public int solution(int[] A) {
        int answer = 0;
        
        for(int i = 0; i < A.length; i++) {
            answer += findLeader(A, i);
        }
        
        return answer;
    }
    
    private static int findLeader(int[] A, int S) {
        int[] arr1 = new int[S+1];
        int[] arr2 = new int[A.length- S];
        
        arr1 = Arrays.copyOfRange(A, 0, S+1);
        arr2 = Arrays.copyOfRange(A, S+1, A.length);
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        int cand1 = arr1[arr1.length / 2];
        int cand2 = arr2[arr2.length / 2];
        int lead1;
        int lead2;
        
        int cnt = 0;
        for(int i = 0; i < arr1.length; i++) {
            if(arr1[i] == cand1) {
                cnt++;
            }
        }
        if(cnt > arr1.length / 2) {
            lead1 = cand1;
        }
        
        cnt = 0;
        for(int i = 0; i < arr2.length; i++) {
            if(arr2[i] == cand2) {
                cnt++;
            }
        }
        if(cnt > arr2.length / 2) {
            lead2 = cand2;
        }
        
        if(lead1 == lead2 && lead1 != 0 && lead2 != 0) 
            return 1;
        else
            return 0;
    }
}