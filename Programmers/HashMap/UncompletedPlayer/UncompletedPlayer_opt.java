import java.util.HashMap;
import java.util.Map;

public class UncompletedPlayer_opt {
    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        String answer = "";

        Map<String, Integer> hm = new HashMap<>();

        for(String part : participant) {
            if(hm.get(part) == null) {
                hm.put(part, 1);
            } else {
                hm.put(part, hm.get(part) + 1);
            }
        }

        for(String comp : completion) {
            hm.put(comp, hm.get(comp) - 1);
        }

        for(String key : hm.keySet()) {
            if(hm.get(key) == 1) answer = key;
        }

        System.out.println(answer);
    }
}