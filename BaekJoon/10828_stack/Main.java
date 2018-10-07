import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        String input = "";
        int inputNum;
        Stack stack = new Stack();
        StringTokenizer st;

        for(int i = 0; i < num; i++) {
            input = sc.nextLine();
            st = new StringTokenizer(input, " ");

            if(st.countTokens() == 2) {
                input = st.nextToken();
                
                if(input.equals("push")) {
                    inputNum = Integer.parseInt(st.nextToken());
                    stack.push(inputNum);
                }
            }

            switch(input) {
               
                case "top" : 
                    System.out.println(stack.top());
                    break;

                case "size" : 
                    System.out.println(stack.size());
                    break;

                case "pop" : 
                    System.out.println(stack.pop());
                    break;

                case "empty" : 
                    System.out.println(stack.empty());
                    break;
            }
        }
    }

    public static class Stack {
        
        private int index;
        private int[] array = new int[10000]; 

        public Stack() {
            index = -1;
        }

        public void push(int n) {
            array[++index] = n;
        }

        public int pop() {
            if(index == -1) {
                return -1;
            }

            return array[(index--)];
        }

        public int top() {
            if(index == -1) {
                return -1;
            }
            return array[index];
        }

        public int empty() {
            if(index == -1) {
                return 1;
            } else {
                return 0;
            }
        }
        
        public int size() {
            return index + 1;
        }
    }
}