// Java String functions 내용 정리

public class Main {
    public static void main(String[] args) {
        String str = "apple";

        // startWith : 문자열이 지정한 문자로 시작하는지 판단
        boolean startWith = str.startsWith("a");
        System.out.println("startsWith : " + startWith);

        // endWith : 문자열이 지정한 문자로 끝나는지 판단
        boolean endWith = str.endsWith("e");
        System.out.println("endsWith : " + endWith);

        // equals : 두 개의 string값을 비교함 case sensitive
        String str1 = "hello";
        String str2 = "hellooo";

        System.out.println(str1.equals(str2));
        System.out.println(str1 == str2);

        // indexOf : 지정한 문자가 문자열의 몇 번째에 있는지 반환
        str = "abcdef";
        System.out.println("indexOf : " + str.indexOf("d"));

        // lastindexOf : 문자열에 지정한 문자가 마지막에 몇 번째에 있는지 반환
        str = "applehaveanapple";
        System.out.println("idnexOf : " + str.lastIndexOf("a"));

        // replace : 문자열에 지정한 문자열 새로 지정한 문자로 바꿔서 출력
        str = "A*B*C*D";
        String replace = str.replace("*", "-");
        System.out.println("replaced : " + replace);

        // split : 지정한 문자로 문자열을 나눔 (배열로 반환)
        str = "A:B:C:D:abcd";
        String[] split = str.split(":");
        for(int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }

        // substring : 문자열에 지정한 범위에 속하는 문자열을 반환 (endIndex 미포함)
        str = "abcdefgh";
        String substring = str.substring(1,3);
        System.out.println("substring : " + substring);

        // trim : 문자열에 첫 공백과 마지막 공백을 없앰
        str = "    hello my name is Jonh   ";
        str = str.trim();
        System.out.println("trimmed : " + str);

        // compareTo

        // contains

        // charAt

        // concat

        // format

        // replaceFirst
    }
}