import java.util.HashMap;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        System.out.println(s.solution(tickets));
    }
}


class Solution {
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        
        // 공항의 갯수 판별 후 배열 만들기
        HashSet<String> set = new HashSet<>();
        int len = tickets.length;

        for (int i = 0; i < len; i++) {
            set.add(tickets[i][0]);
            set.add(tickets[i][1]);
        }

        int size = set.size();
        int[][] route = new int[size][size];
        ArrayList<String> list = new ArrayList<>();
        Iterator<String> iterator = set.iterator();

        while(iterator.hasNext()) {
            list.add(iterator.next());
        }

        Collections.sort(list);
        HashMap<Integer, String> map = new HashMap<>();
        Pair[] pairs = new Pair[size];

        int q = 0;
        for (String s : list) {
            System.out.println(s);
            pairs[q] = new Pair(s, q);
            q++;
            //map.put(q++, s);
        }

        int startIdx = 0;

        for (int i = 0; i < len; i++) {
            String from = tickets[i][0];
            String to = tickets[i][1];

            //int fromIdx = map.get(from);
            //int toIdx = map.get(to);

            int fromIdx = 0;
            int toIdx = 0;
            for (int j = 0; j < size; j++) {
                if (pairs[j].airport.equals(from)) {
                    fromIdx = pairs[j].index;
                }
            }
            for (int j = 0; j < pairs.length; j++) {
                if (pairs[j].airport.equals(to)) {
                    toIdx = pairs[j].index;
                }
            }

            if (from.equals("ICN")) {
                startIdx = fromIdx;
            }

            route[fromIdx][toIdx] = 1;
        }

        // 그래프 완성
        boolean[][] check = new boolean[size][size];

        // ICN 에서 DFS 탐색하면서 경로 저장
        ArrayList<String> answerList = new ArrayList<>();
        dfs(startIdx, pairs, route, size, check, answerList); 

        answer = answerList.toArray(new String[0]);
        
        return answer;
    }

    private void dfs(int index, Pair[] pairs, int[][] route, int size, boolean check[][], ArrayList list) {
        list.add(pairs[index].airport);

        for (int i = 0; i < size; i++) {
            if (check[index][i] == false && route[index][i] == 1) {
                check[index][i] = true;
                dfs(i, pairs, route, size, check, list);
            }
        }
    }
}

class Pair {
    String airport;
    int index;

    public Pair(String airport, int index) {
        this.airport = airport;
        this.index = index;
    }
}

class Ticket {
    int totalTicket;
    int curTicket;

    public Ticket(int totalTicket, int curTicket) {
        this.totalTicket = totalTicket;
        this.curTicket = curTicket;
    }
}