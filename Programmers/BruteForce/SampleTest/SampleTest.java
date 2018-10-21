public class SampleTest {
    public static void main(String[] args) {
        int[] answer = {};
        int[] answers = {1,2,3,4,5};
        
        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};

        int[] count = {0,0,0};
        int j = 0;
        int loopA = a.length;
        int loopB = b.length;
        int loopC = c.length;
        int aIdx, bIdx, cIdx;

        answer = new int[3];
        
        for(int i = 0; i < answers.length; i++) {
            
            if(i > a.length) {
                aIdx = i % loopA;
                if(a[aIdx] == answers[i]) {
                    count[0]++;
                }
            } else {
                if(a[i] == answers[i]) {
                    count[0]++;
                }
            }
            
            if(i > b.length) {
                bIdx = i % loopB;
                if(b[bIdx] == answers[i]) {
                    count[1]++;
                }
            } else {
                if(b[i] == answers[i]) {
                    count[1]++;
                }
            }
            
            if(i > c.length) {
                cIdx = i % loopC;
                if(c[cIdx] == answers[i]) {
                    count[2]++;
                }
            } else {
                if(c[i] == answers[i]) {
                    count[2]++;
                }
            }
        }
        
        int max = 0;
        
        for(int i = 0 ; i <count.length; i++) {
            if(max < count[i]) {
                max = count[i];
            }
        }
        
        int arrCnt = -1;
        for(int i = 0 ; i < count.length; i++) {
            if(max == count[i]) {
                answer[i] = i+1;
                arrCnt++;
            }
        }
        
        System.out.println("al : " + arrCnt);
        int[] tmp = new int[arrCnt+1];

        for(int i = 0 ; i < arrCnt+1; i++) {
            tmp[i] = answer[i];
        }
        //System.out.println();
        answer = tmp;
        for(int i = 0 ; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
       
    }
}