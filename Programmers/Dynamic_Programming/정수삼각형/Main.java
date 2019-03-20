import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(s.solution(triangle));
    }
}

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int len = triangle.length;
        int[][] d = new int[len][len];

        // d[i][j] 는 높이가 i인 삼각형에서 j를 마지막으로 거쳐간 숫자의 최댓 값
        // 0이 꼭대기 층이라고 가정
        d[0][0] = triangle[0][0];
        
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i+1; j++) {
                // 첫 번째 인경우
                if (j == 0) {
                    d[i][j] = triangle[i][j] + d[i-1][j];
                } else if (j == len-1) { // 마지막
                    d[i][j] = triangle[i][j] + d[i-1][j];
                } else { // 중간
                    d[i][j] = Math.max(triangle[i][j] + d[i-1][j-1], triangle[i][j] + d[i-1][j]);
                }
            }
        }

        for (int i = 0; i < len; i++) {
            if (answer < d[len-1][i]) {
                answer = d[len-1][i];
            }
        }
        return answer;
    }
}