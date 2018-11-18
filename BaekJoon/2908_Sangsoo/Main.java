import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        String n1 = st.nextToken();
        String n2 = st.nextToken();
        
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();

        sb1.append(n1);
        sb2.append(n2);
        
        int result1 = Integer.parseInt(sb1.reverse().toString());
        int result2 = Integer.parseInt(sb2.reverse().toString());

        if(result1 > result2) {
            System.out.println(result1);
        } else {
            System.out.println(result2);
        }
    }
}