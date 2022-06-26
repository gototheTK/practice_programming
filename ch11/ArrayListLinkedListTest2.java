import java.util.*;

/**
 * ArrayListLinkedListTest2
 */
public class ArrayListLinkedListTest2 {

    public static void main(String arags[]){
        ArrayList al = new ArrayList(1000000);
        LinkedList ll = new LinkedList();
        add(al);
        add(ll);

        System.out.println("= 접근시간테스트 =");
        System.out.println("Arraylist :" + access(al));
        System.out.println("LinkedList :" + access(ll));
        
    }

    public static void add(List list){
        for(int i=0; i<100000; i++) list.add(i+"");
    }

    public static long access(List list){
        long start = System.currentTimeMillis();
        for (int i=0; i<100000; i++) list.get(i);
        long end = System.currentTimeMillis();
        return end - start;
    }
    
}