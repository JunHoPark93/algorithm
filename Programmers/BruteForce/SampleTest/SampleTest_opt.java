import java.util.*;

public class SampleTest_opt {
    public static void main(String[] args) {
        int[] answer = {};

        ArrayList<Integer> temp = new ArrayList<>();

        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};

        int[] count = {0,0,0};

        for(int i = 0 ; i < answers.length; i++) {
            if(answers[i] == a[i % 5]) {
                count[0] += 1;
            }

            if(answers[i] == b[i % 8]) {
                count[1] += 1;
            }

            if(answers[i] == c[i % 10]) {
                count[2] += 1;
            }
        }

        int max = count[0];
        for(int i = 0; i < count.length; i++) {
            if(max < count[i]) {
                max = count[i];
            }
        }

        for(int i = 0; i < count.length; i++) {
            if(count[i] == max) {
                temp.add(i+1);
            }
        }

        answer = new int[temp.size()];

        for(int i = 0; i < temp.size(); i++) {
            answer[i] = temp.get(i);
        }

        Arrays.sort(answer);

        //return answer;
    }
}