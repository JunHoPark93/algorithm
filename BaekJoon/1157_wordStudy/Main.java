import java.util.HashMap;
import java.util.Scanner;

// 너무 어렵게 생각함 문자와 아스키코드(숫자)와의 관계를 생각하지 못함
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();

        char[] arr = word.toCharArray();
        HashMap<Character, Integer> map = new HashMap();

        // testCase : zZa 에 대해서 실패해서 추가함
        // 대 소문자 구분 없앰
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Character.toUpperCase(arr[i]);
        }
        for(int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])) {
                map.put(arr[i], Integer.parseInt(map.get(arr[i]).toString()) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        
        int maxValue = 0;
        char maxWord = '\0';
        
        for(char alphabet : map.keySet()) {
            if(maxValue < map.get(alphabet)) {
                maxValue = map.get(alphabet);
                maxWord = alphabet;
            }
        }

        int check = 0;
        for(char alphabet : map.keySet()) {
            if(map.get(alphabet) == maxValue) {
                check++;
            }
        }

        if(check == 2) {
            System.out.println("?");
        } else {
            System.out.println(Character.toUpperCase(maxWord));
        }
    }
}