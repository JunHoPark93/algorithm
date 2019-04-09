import java.util.*;

public class Q15486 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Work> workList = new ArrayList<>();
        int[] d = new int[n+100];

        for (int i = 0; i < n; i++) {
            int workingDay = sc.nextInt();
            int money = sc.nextInt();
            workList.add(new Work(workingDay, money));
        }

        // d[i] : i번째 날 일했을 때 최대 수익
        // i일의 날에 상담을 하는 경우, 상담을 하지 않는 경우
        for (int i = 0; i < n; i++) {
            d[i + workList.get(i).workingDay] = Math.max(d[i+workList.get(i).workingDay], d[i] + workList.get(i).money);
            d[i+1] = Math.max(d[i], d[i+1]);
        }

        System.out.println(d[n]);
    }
}

class Work {
    int workingDay;
    int money;
    public Work(int workingDay, int money) {
        this.workingDay = workingDay;
        this.money = money;
    }
}