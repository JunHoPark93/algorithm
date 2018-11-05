class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        for(int i = 0; i < phone_book.length; i++) {
            String temp = phone_book[i];
            for(int j = 0; j < phone_book.length; j++) {
                if(i == j) {
                    continue;
                }
                if(temp.startsWith(phone_book[j])) {
                    if(temp.contains(phone_book[j]) || phone_book[j].contains(temp)) {
                        answer = false;
                        break;
                    }

                }
            }
        }

        return answer;
    }
}