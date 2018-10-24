import java.util.*;

class Solution {
    public int solution(int X, int[] A) {
        int len = A.length;
        Set<Integer> set = new HashSet<>();

        for(int i = 1; i < len + 1; i++) {
            if(A[i] <= X) {
                set.add(A[i]);
                if(set.size() == X) {
                    return i;
                }
            }
        }
        
        return -1;
    }
}