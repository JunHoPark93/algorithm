import java.util.*;

class Solution {
    public int solution(int[] A) {
        Set<Integer> set = new HashSet<>();
        
        for(int a : A) {
            set.add(a);
        }
        
        return set.size();
    }
}