import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int num = sc.nextInt();

        int num = Integer.parseInt(sc.nextLine());
        String[] input = new String[num];

        for(int i = 0; i < num; i++) {
            input[i] = sc.nextLine();
        }

        for(int i = 0; i < num ; i++) {
            repeatWord(input[i]);
            System.out.println();
        }
    }

    private static void repeatWord(String input) {

        String[] token = input.split("\\s");

        int repeat = Integer.parseInt(token[0]);
        char[] arr = token[1].toCharArray();

        for(int i = 0; i < arr.length; i++) {
            for(int j=0; j < repeat; j++) {
                System.out.print(arr[i]);
            }
        }
    }
}