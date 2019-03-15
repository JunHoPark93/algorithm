import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;

class Main {
    public static void main(String[] args) {
        String[][] str = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        Solution solution = new Solution();
        System.out.println(solution.solution(str));
    }
}

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        
        HashMap<String,Integer> map = new HashMap<>();

        int length = clothes.length;
        for (int i = 0; i < length; i++) {
            if (map.containsKey(clothes[i][1])) {
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
            } else {
                map.put(clothes[i][1], 1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            list.add(map.get(key));
        }
        int sum = 1;
        for (int n : list) {
            System.out.println(n);
            sum *= (n+1);
        }

        sum = sum - 1;
        return sum;
    }
}