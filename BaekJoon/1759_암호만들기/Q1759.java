import java.util.*;

import java.io.*;

public class Q1759 {
    static int c,l;
    static String[] input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] condition = br.readLine().split(" ");
        c = Integer.parseInt(condition[0]);
        l = Integer.parseInt(condition[1]);

        input = br.readLine().split(" ");
        Arrays.sort(input);
        go(0,"");
    }
    private static void go(int idx, String password) {
        if(password.length() == c) {
            if(check(password)) {
                System.out.println(password.toString());
            }
            return;
        }

        if(idx >= l) {
            return;
        }

        go(idx+1, password + input[idx]);
        go(idx+1, password);
    }

    private static boolean check(String password) {
        char[] check = password.toCharArray();
        int consonant = 0;
        int vowel = 0;
        for(char c : check) {
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowel ++;
            } else {
                consonant ++;
            }
        }
        return vowel >= 1 && consonant >= 2 ? true : false;
    }
}