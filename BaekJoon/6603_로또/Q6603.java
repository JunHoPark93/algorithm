import java.util.*;

import java.io.*;

public class Q6603 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String input[] = br.readLine().split(" ");

            int size = Integer.parseInt(input[0]);

            if(size == 0) {
                break;
            }

            String[] lotto = new String[size];

            for (int i = 0; i < size; i++) {
                lotto[i] = input[i+1];
            } 

            List<String> combination = new ArrayList<>();
            // 재귀
            go(lotto, combination, 0);
            System.out.println();
        }
    }

    private static void go(String[] lotto, List<String> combination, int index) {
        if (combination.size() == 6) {
            for (String list : combination) {
                System.out.print(list + " ");
            }
            System.out.println();
            return;
        }

        if (index >= lotto.length) {
            return;
        }
    
        combination.add(lotto[index]);
        go(lotto, combination, index+1);
        combination.remove(lotto[index]);
        go(lotto, combination, index+1);
    }
}