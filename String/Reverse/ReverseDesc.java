/**
 * reverseStr 메소드는 String형 변수 str을 매개변수로 입력받습니다.

str에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 String을 리턴해주세요.
str는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
예를들어 str이 Zbcdefg면 gfedcbZ을 리턴하면 됩니다.
 */

 import java.util.*;

public class ReverseDesc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String ans = reverseDescOrder(str);
        System.out.println(ans);
    }

    private static String reverseDescOrder(String str) {
        char[] temp = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append(temp);
        return sb.reverse().toString();
    }
}