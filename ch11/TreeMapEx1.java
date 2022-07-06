import java.util.*;

/**
 * TreeMapEx1
 */
public class TreeMapEx1 {

    public static void main(String[] args) {

        String[] data = {"A", "K", "A", "K", "D", "K", "A", "K", "k", "Z", D};

        TreeMap map = new TreeMap<>();

        for(int i = 0; i < data.length; i++) {
            if(map.containsKey(data[i])) {
                Integer value = (Integer)map.get(data[i]);
                map.put(data[i], new Integer(value.intValue() + 1));
            } else {
                map.put(data[i], new Integer(1));
            }
        }

        Iterator it = map.entrySet().iterator();

        System.out.println("= 기본정렬 =");
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            int value = ((Integer)entry.getValue()).intValue();
        }

    }
    
}