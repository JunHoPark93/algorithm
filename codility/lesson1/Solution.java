// you can also use imports, for example:
// import java.util.*;
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public static void main(String[] args)  {
        // write your code in Java SE 8
        
        int N = 31;
        int answer;
        ArrayList<Integer> arr = new ArrayList();
        ArrayList<Integer> check = new ArrayList();
        
        while(true) {
            arr.add(N%2);
            N = N / 2;
            
            if(N == 1) {
                arr.add(1);
                break;
            }
        }
        
        Collections.reverse(arr);
        boolean flag = false;
        int cnt = 0;
    
        for(int i = 1; i < arr.size(); i++) {
            if(arr.get(i) == 0 && flag == true) {
                cnt ++;
            } else if(arr.get(i) == 1 && flag == true) {
                check.add(cnt);
                cnt = 0;
            }
        }
        
        if(check.isEmpty()) {
            check.add(0);
        }

        System.out.println(check);
                
        //answer = Collections.max(check);
        
        
        //System.out.println(arr);
        //System.out.println(answer); 
    }
}