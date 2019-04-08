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

        // compareTo : 2개의 문자열을 비교하고 int형 값을 반환하는 메서드 (같으면 0, 사전 순으로 작으면 음수, 크면 양수)
        str = "abc";
        System.out.println("compareto : " str.compareTo("abc"));
        System.out.println("compareto : " str.compareTo("abd"));

        // contains : 특정 문자열이 포함되어 있는지 확인하는 기능 (있으면 true, 없으면 false)
        str = "I have a pen";
        System.out.println("contains : " + str.contains("pen"));

        // concat : 합친 문자열을 String 으로 생성해준다.
        str = "Hi";
        System.out.println(str.concat("Hello"));

        // replaceFirst : 바꾸고 싶은 문자열이 처음으로 해당할 때만 바꾸어 준다.
        str = "hi my name is park hi hi";
        str = str.replaceFirst("hi", "hello");
        System.out.println(str);
    }
}