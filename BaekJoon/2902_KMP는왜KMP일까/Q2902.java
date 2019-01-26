import java.util.*;
import java.io.*;

public class Q2902 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split("-");

        for(String s : line) {
            System.out.print(s.charAt(0));
        }
    }
}