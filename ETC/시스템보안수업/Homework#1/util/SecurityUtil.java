/**
 * 유틸 클래스
 * 기능 1: 한글을 분리하여 영어 자판으로 변환시켜줌
 * 기능 2: 0 은 o 로 l 은 1 로 변환 + 특수문자파 변환 
 */
public class SecurityUtil {
    private static final String[] CHO = {"r","R","s","e","E","f","a","q","Q","t",
            "T","d","w","W","c","z","x","v","g"};
    private static final String[] JUNG = {"k", "o","i","O","j","p","u","P","h","hk","ho","hl","y","n","nj","np","nl","b",
            "m","ml","l"};
    private static final String[] JONG = {"r", "R", "rt", "s", "sw", "sg", "e", "f", "fr", "fa", "fq", "ft", "fx", "fv",
            "fg", "a", "q", "qt", "t", "T", "d", "w", "c", "z", "x", "v", "g"};
    private static final String[] SPECIAL = {"\"",")","!","@","#","$","%","^","&","*","("};

    public static String convertKoreanToEnglish(String korean) {
        int inputLength = korean.length();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < inputLength; i++) {
            char c = korean.charAt(i);
            if (!checkIfNotValidWord(c)) {
                try {
                    sb.append(convertSingleKoreanCharToEnglishChar(c));
                } catch (Exception e) {
                    return "한글이 아닙니다";
                }
            } else {
                return "한글 단어 형식이 아닙니다";
            }
        }
        return sb.toString();
    }

    public static String converToSpecialCharacter(String input) {
        int inputLength = input.length();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < inputLength; i++) {
            char c = input.charAt(i);
            convertIfNumberOfLOrO(sb, c);
        }

        return sb.toString();
    }

    private static StringBuilder convertIfNumberOfLOrO(StringBuilder sb, char c) {
        if (c == 'l') {
            sb.append("1");
        } else if (c == 'o') {
            sb.append("0");
        } else if ('0' <= c && c <= '9') {
            sb.append(SPECIAL[Character.getNumericValue(c)+1]);
        } else {
            sb.append(c);
        }
        return sb;
    }

    private static String convertSingleKoreanCharToEnglishChar(char c) {
        StringBuilder sb = new StringBuilder();
        int choSung = ((c - 0xAC00) / 28 ) / 21;
        sb.append(CHO[choSung]);

        int jungSung = ((c - 0xAC00) / 28) % 21;
        sb.append(JUNG[jungSung]);

        int jongSung = (c - 0xAC00) % 28;
        if (jongSung != 0) {
            sb.append(JONG[jongSung-1]);
        }
        return sb.toString();
    }

    private static boolean checkIfNotValidWord(char c) {
        return (c >=0x3130) && (c < 0x318F);
    }
}
