import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] prices = {1,2,3,2,3};
        int[] answer = s.solution(prices);

        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = {};
        ArrayList<Integer> arr = new ArrayList<>();
        
        int len = prices.length;
        for (int i = 0; i < len; i++) {
            int temp = prices[i];
            int count = 0;
            for (int j = i+1; j < len; j++) {
                if (temp <= prices[j]) {
                    count++;
                } else {
                    count++;
                    break;
                }
            }
            arr.add(count);
        }
        
        answer = arr.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}