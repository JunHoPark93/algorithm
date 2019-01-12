import java.util.*;

public class Q2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dwarfs = new int[9];
        int originSum = 0;

        for (int i = 0; i < 9; i++) {
            dwarfs[i] = sc.nextInt();
            originSum += dwarfs[i];
        }

        Arrays.sort(dwarfs);

        for (int i = 0; i < 9; i++) {
            for (int j = i+1; j < 9; j++) {
                if (originSum - dwarfs[i] - dwarfs[j] == 100) {
                    for (int k = 0; k < 9; k++) {
                        if(k == i || k == j) continue;
                        System.out.println(dwarfs[k]);
                    }
                    System.exit(0);
                }
            }
        }
    }
}