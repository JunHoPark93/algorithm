import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 사람 수 입력
        Scanner sc = new Scanner(System.in);
        int INF = 1000000000;
        int num = sc.nextInt();
        int x; // 사람 1
        int y; // 사람 2
        int[] answer = new int[num+1]; // 답 넣을 배열

        // 배열 초기화
        int pp[][] = new int[num+1][num+1]; // 1번 사람부터 시작 하므로 0번째는 비우려고 함

        for(int i = 1 ; i < num + 1; i++) {
            for(int j = 1; j < num + 1; j++) {
                pp[i][j] = (i==j) ? 0 : INF;
            }
        }

        while(true) {
            x = sc.nextInt();
            y = sc.nextInt();

            if(x == -1 && y == -1) {
                break;
            }

            // 양방향
            pp[x][y] = 1;
            pp[y][x] = 1;
        }

        // 플로이드 와샬적용
        for(int k = 1; k < num + 1; k++) {
            for(int i = 1; i < num + 1; i++) {
                for(int j = 1; j < num + 1; j++) {
                    if(pp[i][j] > pp[i][k] + pp[k][j]) {
                        pp[i][j] = pp[i][k] + pp[k][j];
                    }
                }
            }
        }

        int temp;
        // 출력 최솟값, 개수, 최솟값의 인덱스
        for(int i = 1; i < num + 1 ; i++) {
            temp = 0;
            for(int j = 1; j < num + 1; j++) {
                if(pp[i][j] > temp) {
                    temp = pp[i][j];
                }
            }
            answer[i] = temp;
        }

        int minValue = 999;
        for(int i = 1; i < answer.length; i++) {
            if(answer[i] < minValue) {
                minValue = answer[i]; // 회장 후보 점수 선출
            }
        }

        int count = 0;
        String index = "";
        for(int i = 1; i < answer.length; i++) {
            if(minValue == answer[i]) {
                count ++;
                index += i + " ";
            }
        }

        System.out.println(minValue + " " + count);
        System.out.println(index);
    }
}