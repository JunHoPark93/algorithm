import java.util.*;

class Solution {
    public int solution(String S) {
        Stack<Character> stack = new Stack<>();
        
        if(S.length() == 0) {
            return 1;
        }
        
        char[] arr = new char[S.length()];
        
        for(int i = 0; i < S.length(); i++) {
            arr[i] = S.charAt(i);
        }
        
        for(int i = 0; i < S.length(); i++) {
            
            if(arr[i] == '{' || arr[i] == '[' || arr[i] == '(') {
                stack.push(arr[i]);
                
            } else if(arr[i] == '}' && !stack.isEmpty()) {
                if(stack.pop() == '{') {
                    continue;
                } else {
                    return 0;
                }
            } else if(arr[i] == ')' && !stack.isEmpty()) {
                if(stack.pop() == '(') {
                    continue;
                } else {
                    return 0;
                }
            } else if(arr[i] == ']'&& !stack.isEmpty()) {
                if(stack.pop() == '[') {
                    continue;
                } else {
                    return 0;
                }
            }
        }
        
        return 1;
    }
}