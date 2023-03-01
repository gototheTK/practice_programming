# Thread

목차
---
1. Thread
2. 동기적, 비동기적, 병렬적
3. 비동기적 문제 해결하기(간단)
4. Daemon Thread

---
---

1\.Thread
---
    
### Thread

    프로그램의 작업 혹은 실행 상태를 프로세스(Process)라고 하는데, 프로세스를 구성하는 작은 작업을 스레드(Thread)라고 합니다.
    
    자바에서는 메인 실행을 담당하는 메인 스레드(Main Thread)외에 스레드를 추가하여 작업을 병렬적으로 처리 할 수 있도록하는 멀티 스레드를 지원합니다.


### 스레드를 사용하는 방법

    1. 스레드를 사용하기 위해서는 사용할 클래스를 만들어 Runnable이라는 인터페이스를 상속받아 run()이라는 메서드를 구현합니다.
    
    2. 스레드 객체를 생성하는데, 생성자의 파라미터에 실행할 Runnable을 상속받은 객체를 전달하여 줍니다.

    3. Runnable를 상속받은 객체의 start()라는 메서드를 호출하여, 스레드로 구현한 run()을 벙렬처리하게 합니다.

  ```

    package java.lang;

    public interface Runnable {
        public abstract void run();

        ...
        
    }

    ...
  
    Thread thread = new Thread(Runnalbe 구현 겍체만 가능);
    thread.start();

  ```

### 예제) 스레드를 사용하여 0에서 10억까지의 짝수를 더하는 프로그램


```


public class Task implements Runnable {

  private long sum = 0;
  private final long from;  // ~ 에서
  private final long to;  // ~ 까지

  public Task(long from, long to) {
    this.from = from;
    this.to = to;
  }

  public void run() {
    for  (long i = from; i <= to; i++) {
      if(0 == i%2) {
        sum += i;
      }
    }
  }

  public long getSum() {
    return sum;
  }

}


// 그리고 start() 메서드가 호출되면 Runnable의 run() 메서드를 실행합니다.

// 계산해야 할 작업
Task task1 = new Task(0, 500000000);
Task task2 = new Task(500000001, 1000000000);

// 스레드의 생성
Thread threadA = new Thread(task1);
Thread threadB = new Thread(task2);

// 스레드 실행
threadA.start();
threadB.start();

System.out.println(task1.getSum() + task2.getSum());
// 출력 결과는 비동기적으로만 처리했기때문에 의도한 대로 나오지 않습니다.

```

2\. 동기적, 비동기적, 병렬적
---

### 동기적과 비동기적

  프로세스 작업 처리 수행 방식은 동기적 처리방식과 비동기적 처리방식이 있습니다.
    
  - 동기적은 이전 작업이 끝나고 다음 작업의 처리를 수행하는 처리 방식입니다.
  - 비동기적은 이전 작업의 수행완료와 상관없이 작업의 처리 수행 명령만 내리고 다음 작업을 수행하는 처리 방식입니다.

### 병렬적

  병렬적은 특정 시점에서 동시에 여러 작업을 처리하는 방식을 뜻합니다. 이는 단시간내에 여러 작업을 빨리 끝내기 위함입니다. 다만, 작업의 시작 순서와 상관없이 끝나는 순서를 통제할 수가 없습니다.

3\. 위의 예제 비동기적 문제 해결하기(간단)
---

### thread.join()


  스레드를 생성하여 호출하면 비동기적으로 병렬처리가 일어나, 의도한대로 처리가 되지 않습니다. 이를 해결하기 위해 Thread의 인스턴스 메서드인 join()을 호출하여 해결할 수 있습니다. 중간에 쓰레드객체로 join()메서드를 호출하면, 해당 쓰레드의 작업이 끝날때까지 기다려줍니다. 파라미터로 long이나 int값의 인자를 전달하면, 해당하는 밀리, 나노초만큼 기다려줍니다. 여기서는 Main스레드가 잠시 작업을 멈추고, threadA의 작업이 끝날때까지 기다립니다. Main스레드의 작업이 멈춘것이지 다른 스레드의 작업이 멈춘것이 아니기때문에, threadB의 작업이 먼저 끝나는지 threadA의 작업이 먼저 끝나는지 알수가 없습니다.

```

try {

  // 계산해야 할 작업
  Task task1 = new Task(0, 500000000);
  Task task2 = new Task(500000001, 1000000000);

  // 스레드의 생성
  Thread threadA = new Thread(task1);
  Thread threadB = new Thread(task2);

  // 스레드 실행
  threadA.start();
  threadB.start();

  // A, B 스레드의 작업이 끝나기까지 기다린다.
  threadA.join();
  threadB.join();

  System.out.println(task1.getSum() + task2.getSum());
  // 출력 250000000500000000
  
} catch (InterruptedException e) {
  e.printStackTrace();
}


```


---

4\. Daemon Thread
---

Thread중에 Main Thread가 종료되면, Sub Thread의 처리중의 유무와 관계없이 같이 종료되는 Thread가 있는데 이를 Deamon Thread라고 합니다. 이 Deamon Thread를 설정하기 위해서는 thread.start()를 하기전에 설정하여 주어야합니다.

```

Thread thread = new Thread(runnable);
thread.setDaemon(true);

```


### Deamon Thread 예제

Person.java

```
public class Person implements Runnalbe {

  public String name;
  public Person(String name) {
    this.name= name;
  }

  public void run() {
    int sum = 0;
    for (int i = -; i < 100; i++) {
        sum += i;
    }
    System.out.println(name+":"+sum);
  }

}

Main.java

public class Main {
 
  public static void mian(String[[] args) {
    Thread threadA = new Thread(new Person("thread A"));
    threadA.setDaemon(true);
    Thread threadB = new Thread(new Person("thread B"));
    threadB.setDaemon(true);

    threadA.start();
    threadB.start();
    System.out.println("Main Thread는 일을 마쳤다.")
    /**

    Main Thread는 일을 마쳤다.
    또는
    Main Thread는 일을 마쳤다.
    thread A: 4950
    또는
    Main Thread는 일을 마쳤다.
    thread A: 4950
    thread B: 4950

    **/
  }

}


```


