import java.util.HashMap;
import java.util.Map;


public class UncompletedPlayer {
    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for(int i = 0; i < participant.length; i++) {
            if(map.containsKey(participant[i])) {
                map.put(participant[i], map.get(completion[i]) + 1);
            } else {
                map.put(participant[i], 1);
            }
        }
        
        for(int i = 0; i < completion.length; i++) {
            if(map.containsKey(completion[i])) {
                map.put(completion[i], Integer.parseInt(map.get(completion[i]).toString()) - 1);
            } 
        }

        for(Map.Entry entry : map.entrySet()) {
            if(Integer.parseInt(entry.getValue().toString()) == 1) {
                System.out.println(entry.getKey());
            }
        }
       
        System.out.println(map);
    }
}