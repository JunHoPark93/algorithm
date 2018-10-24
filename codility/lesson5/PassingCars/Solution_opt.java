public class Solution_opt {
    public int solution(int[] A) {
        int len = A.length;
        int rDir = 0;
        int cnt = 0;
        
        for(int i = 0; i < len; i++) {
            if(A[i] == 0) {
                rDir++;
            } else {
                cnt += rDir;
            }
            
            if(cnt > 1000000000) {
                return -1;
            }
        }
        
        return cnt;
    }
}