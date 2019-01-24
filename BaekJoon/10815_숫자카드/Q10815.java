import java.util.*;
import java.io.*;

public class Q10815 {
    static int[] card;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.valueOf(br.readLine());
        String[] nLine = br.readLine().split(" ");
        card = Arrays.stream(nLine).mapToInt(Integer::valueOf).toArray();

        Arrays.sort(card);

        int m = Integer.valueOf(br.readLine());
        String[] mLine = br.readLine().split(" ");
        int[] comparingNum = Arrays.stream(mLine).mapToInt(Integer::valueOf).toArray();

        for (int i = 0; i < m; i++) {
            if (checkIfExists(comparingNum[i])) {
                System.out.print(1+ " ");
            } else{
                System.out.print(0 + " ");
            }
        }
    }

    private static boolean checkIfExists(int num) {
        int left = 0;
        int right = n-1;
        int mid;

        while (left <=right) {
            mid = (left + right) / 2;
            if (card[mid] == num) {
                return true;
            } else if (num > card[mid]) {
                left = mid + 1;
            } else if (num < card[mid]) {
                right = mid - 1;
            }
        }

        return false;
    }
}