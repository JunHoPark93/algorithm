import java.util.*;

public class Q14226 {
    static final int MAX = 1001;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        boolean[] check = new boolean[MAX];
        Queue<Emoji> q = new LinkedList<>();

        q.add(new Emoji(1,0,0)); // 처음에 이모티콘의 갯수 1, 클립 보드 이모티콘의 갯수 0, 시간 0
        check[1] = true;

        while(!q.isEmpty()) {
            Emoji emoji = q.poll();
            int curScreen = emoji.screen;
            int curClip = emoji.clip;
            int curTime = emoji.time;

            if (curScreen == n) {
                System.out.println(curTime);
                break;
            }

            if (curScreen + curClip <= n) {
                if (check[curScreen + curClip] == false) { // 클립보드 붙여 넣기
                    q.add(new Emoji(curScreen + curClip, curClip, curTime + 1));
                    check[curScreen + curClip] = true;
                }
            }
            
            if (curScreen - 1 >= 0) {
                if (check[curScreen - 1] == false) { // 하나 삭제
                    q.add(new Emoji(curScreen - 1, curClip, curTime + 1));
                    check[curScreen - 1] = true;
                }
            }

            q.add(new Emoji(curScreen, curScreen, curTime + 1)); // 클립 보드 복사
        }
    }
}

class Emoji {
    int screen; int clip; int time;
    public Emoji(int screen, int clip, int time) {
        this.screen = screen;
        this.clip = clip;
        this.time = time;
    }
}