import java.util.*;

public class Q14888 {
    static int plus;
    static int minus;
    static int multiple;
    static int divide;
    static int N;
    static int max = -1000000000;
    static int min = 1000000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        int[] numbers = new int[N];
        
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt(); 
        }
        sc.nextLine();
        plus = sc.nextInt();
        minus = sc.nextInt();
        multiple = sc.nextInt();
        divide = sc.nextInt();

        
        go(numbers,numbers[0],1,plus, minus, multiple, divide);

        System.out.println(max);
        System.out.println(min);
    }

    static void go(int[] numbers, int curVal, int index, int plusIdx,int minusIdx, int multipleIdx,int divideIdx) {
        if (index == N) { // 계산 해야 함
            if (curVal < min) {
                min = curVal;
            }

            if (curVal > max) {
                max = curVal;
            }

            return;
        }

        if(plusIdx > 0) {
            go(numbers, curVal + numbers[index], index+1, plusIdx-1, minusIdx, multipleIdx, divideIdx);
        }

        if(minusIdx > 0) {
            go(numbers, curVal - numbers[index], index+1, plusIdx, minusIdx-1, multipleIdx, divideIdx);
        }

        if(multipleIdx > 0) {
            go(numbers, curVal * numbers[index], index+1, plusIdx, minusIdx, multipleIdx-1, divideIdx);
        }

        if(divideIdx > 0) {
            go(numbers, curVal / numbers[index], index+1, plusIdx, minusIdx, multipleIdx, divideIdx-1);
        }
    }
}