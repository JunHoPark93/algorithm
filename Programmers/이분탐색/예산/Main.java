
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] budgets = {120, 110, 140, 150};
        int M = 485;
        System.out.println(s.solution(budgets, M));
    }
}

class Solution {
    public int solution(int[] budgets, int M) {
        int answer = 0;

        int len = budgets.length;
        int max = 0;
        int min = 100000;

        for (int i = 0; i < len; i++) {
            if (max < budgets[i]) {
                max = budgets[i];
            }
            if (min > budgets[i]) {
                min = budgets[i];
            }
        }

        int left = min; int right = max; 

        while (left < right) {
            int mid = (left+right+1)/2;
            int sum = 0;
            if (isMatchRange(mid, budgets, M)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        answer = left;
        return answer;
    }

    private static boolean isMatchRange(int mid, int[] budgets, int M) {
        int sum = 0;
        for (int i = 0; i < budgets.length; i++) {
            if (budgets[i] < mid) {
                sum += budgets[i];
            } else {
                sum += mid;
            }
        }
        if (sum <= M) {
            return true;
        }
        return false;
    }
}