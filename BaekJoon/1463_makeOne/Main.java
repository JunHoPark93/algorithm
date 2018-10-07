import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());

        int[] arr = new int[num+1];

        for(int i = 2; i < num+1; i++) {
            arr[i] = Integer.MAX_VALUE;

            if(i % 3 == 0) {
                arr[i] = Math.min(arr[i], arr[i/3] + 1);
            }

            if(i % 2 == 0) {
                arr[i] = Math.min(arr[i], arr[i/2] + 1);
            }

            arr[i] = Math.min(arr[i], arr[i-1] + 1);
        }

        System.out.print(arr[num]);      
    }
}