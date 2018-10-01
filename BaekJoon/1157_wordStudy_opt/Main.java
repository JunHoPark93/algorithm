import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        input = input.toUpperCase();
        int[] word = new int[26];
        String result = "";
       
        for(int i = 0; i < input.length(); i++) {
            word[input.charAt(i)-'A']++;
        }

        int max = 0;

        for(int i = 0; i < word.length; i++) {
            if(max == word[i]) {
                result = "?";
            }
            if(word[i] > max) {
                max = word[i];
                result = Character.toString((char)(i+'A'));
            }
        }
        System.out.println(result);
    }
}