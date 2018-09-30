import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("Bob", 10);
        map.put("Marry", 20);
        map.put("Jogn", 50);
        map.put("Morgan", 5);
        map.put("James", 30);

        Set set = map.entrySet();
        Iterator it = set.iterator();

        while(it.hasNext()) {
            Map.Entry e = (Map.Entry)it.next();
            System.out.println("Name : " +  e.getKey() + "Number : " + e.getValue());
        }

        set = map.keySet();
        System.out.println("Names : " + set);
    }
}