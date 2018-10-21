import java.util.*;

public class KthNumber {
    public static void main(String[] args) {
        int[] answer = {};
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1},{1, 7, 3}};
        int[] temp = {};

        answer = new int[commands[0].length];
        
        for(int i = 0; i < commands[0].length; i++) {
            
            temp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(temp);

            answer[i] = temp[commands[i][2] - 1];
        }
        for(int i = 0 ; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}