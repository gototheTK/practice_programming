import java.util.*;


public class QueueTest {


  public static void main(String[] args) {

    //Queue의 생성
    /**
    중간에 데이터에 접근하지 않는다면, 맨 앞과 뒤의 데이터의 접근이 용이한 LinkedList클래스를 사용하는것이 바람직하다.
    **/
    Queue<String> queue = new LinkedList<>();
    Queue<String> queue = new ArrayDeque<>();

    //Queue의 데이터 삽입
    queue.add("test1");
    queue.add("test2");
    queue.add("test3");
    queue.add("test4");
    queue.add("test5");

    // Queue의 데이터 꺼내기
    // 데이터를 꺼내면 데이터는 삭제되고, 데이터가 없다면 null을 반환한다.
    String poll = queue.poll();

    // 가장 먼저 들어가서 나올 데이터를 확인
    String peek = queue.peek();

    // 데이터가 존재하는지 확인
    boolean isEmpty = queue.isEmpty();

    // 데이터의 개수 확인
    int size = queue.size();
    
    
  }
  
}