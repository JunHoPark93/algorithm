import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        ArrayList<String> list = new ArrayList<String>();
        String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };

        int[] result = new int[26];
        for(int i = 0; i < 26; i++) {
            result[i] = -1;
        }

        char[] inputArr = input.toCharArray();

        for(int i = 0; i < inputArr.length; i++) {

            if(list.contains(inputArr[i])) {
                continue;
            }

            for(int j = 0; j < alphabet.length; j++) {
                if(String.valueOf(inputArr[i]).equals(alphabet[j])) {
                    result[j] = i;
                    list.add(alphabet[j]);
                }
            }
    
        }

        for(int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}