import java.util.*;


public class StackTest{

  public static void main(String[] args) {

    // 참고로 Vector클래스를 상속받았다. Vector는 Thread와의 동기화를 위해 synchronized 키워드가 선언되어있다. 흔히 Threadsafe하다고도 한다.
    Stack<String> stack = new Stack<>();

    stack.push("test1");
    stack.push("test2");
    stack.push("test3");
    stack.push("test4");
    stack.push("test5");

    System.out.println("맨 위의 데이터를 확인: " + stack.peek());

    // 존재하면 맨 위로부터의 깊이를 반환하고, 존재하지 않으면 -1을 반환;
    System.out.println("데이터의 위치를 확인 존재확인: " + stack.search(test3));

    // 데이터가 존재하지 않음에도 실행하면 EmptyStackException 발생.
    System.out.println("맨 위의 데이터를 꺼낸다.:" + stack.pop());

    // 데이터가 존재하는지 비어있는지 확인(존재:false, 미존재:true)
    System.out.println("데이터가 존재하는지 확인: " + stack.isEmpty());
    
  }
  
}