import java.util.*;

public class ReverseString {
    public static void main(String[] args) {
        reverse("zxcDaAc");
    }

    private static void reverse(String s) {
        char[] arr = s.toCharArray();
        System.out.println(arr);

        StringBuilder sb = new StringBuilder(new String(arr));
        System.out.println(sb.reverse().toString());
    }
}