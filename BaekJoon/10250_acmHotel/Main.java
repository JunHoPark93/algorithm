import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int x; // 방수
        int y; // 층수
        int user;
        int num;
        String roomNumber = "";

        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        String[] answer = new String[num];

        for(int i = 0; i < num; i++) {
            y = sc.nextInt();
            x = sc.nextInt();
            user = sc.nextInt();
            
            int floor = user % y;
            int room;

            if(floor == 0) {
                floor = y;
                room = (user / y);
            } else {
                room = (user / y) + 1; 
            }

            roomNumber = String.valueOf(floor);
        
            if(room < 10) {
                roomNumber = roomNumber + "0" + room;
            } else {
                roomNumber = roomNumber + room;
            }
            
            answer[i] = roomNumber;
        }
        
        for(int i = 0; i < num; i++) {
            System.out.println(answer[i]);
        }
    }
}