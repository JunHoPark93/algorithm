import java.util.*;
import java.io.*;

public class Q1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        ArrayList<Meeting> list = new ArrayList<>();
        
        while (num-- > 0) {
            String[] input = br.readLine().split(" ");
            int startTm = Integer.parseInt(input[0]);
            int endTm = Integer.parseInt(input[1]);

            list.add(new Meeting(startTm, endTm));
        }

        Collections.sort(list);
        
        int count = 0;

        int temp = -1;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).startTm >= temp) {
                count ++;
                temp = list.get(i).endTm;
            }
        }
        System.out.println(count);
    }
}

class Meeting implements Comparable<Meeting> {
    int startTm;
    int endTm;

    public Meeting(int startTm, int endTm) {
        this.startTm = startTm;
        this.endTm = endTm;
    }

    public int compareTo(Meeting that) {
       if (this.endTm < that.endTm) {
           return -1;
       } else if (this.endTm ==  that.endTm) {
           if (this.startTm < that.startTm) {
               return -1;
           } else if (this.startTm > that.startTm) {
               return 1;
           } else {
               return 0;
           }
       } else {
           return 1;
       }
    }
}
