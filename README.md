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

---
---


CPU와 스레드
---

목차
---
1. CPU
2. Core와 Process의 관계
3. 스레드의 종류
4. Context Switching COst


1.CPU
---

CPU는 컴퓨터의 실행과 제어를 담당하는 핵심부분입니다.

## Core

CPU에서 실제로 연산을 담당하는 부위입니다.


## Clock

Clock은 Core가 동작하기위해 디지털신호(0또는1)를 생성하는 작업을 뜻하고, 단위로는 Hz를 사용합니다. 1초당안 얼마나 많은 디지털 신호를 생성하는가라는 성능의 척도로 사용할 수 있으나, Clock이 높아도 i5, i7와같이 코어의 종류가 다르면 연산속도가 느릴 수도있습니다. 비유하자면, 삽으로 많은 삽질을 해도 포크레인의 몇번의 삽집을 이길 수 없는거와 비슷합니다.

## Core와 Process의 관계

CPU의 Core가 실제로 Process를 Thread단위로 처리합니다.


3\. 스레드의 종류
---

Thread는 작업의 실행 흐름 단위라고 했었습니다.

이러한 Thread에는 크게 두 가지로 나뉩니다.

  - 하드웨어 스레드
  - 소프트웨어 스레드

## 하드웨어 스레드

하드웨어 스레드는 CPU Core 내에 thread를 뜻하며, 일반적으론 1 Core 당 1 thread로 구성되어있으나 CPU의 아키텍처가 발전되기도 했고, 비싼 자원을 더 효율적으로 사용하기 위해 SMT기술을 이용한 가상 스레드라는 개념이 추가되어 1 Core에 2개의 Thread로 구성되기도 합니다.


물론 그 이상으로 발전할 수도 있습니다.


## 소프트웨어 스레드

소프트웨어 스레드에는 크게 커널 레벨 스레드와 사용자 레벨 스레드가 존재하는데요. 운영체제에는 가장 핵심인 커널이라는 것이 존재하며, 다양한 하드웨어들을 적절하게 관리합니다.



커널이 관리하는 것들 중에서 CPU를 스케줄링에 따라 Core의 하드웨어 스레드를 논리적으로 관리하는 스레드를 커널 레벨 스레드라고 합니다.


## Kerner Level Thread(Native Thread)

커널 레벨 스레드는 하드웨어 스레드를 이용하여 커널이 스레드의 생성 및 스케줄링을 관리합니다. 그리고 Process는 운영체제로부터 하나 이상의 커널 스레드를 할당받으며, 할당받은 스레드를 이용하여 Process를 실행하고 운영합니다.


## User Level Thread

사용자 레벨 스레드는 커널 레벨 스레드를 이용하여 논리적으로 생성하고 관리하는 스레드를 사용자 레벨 스레드라고 합니다. 커널 스레드와 사용자 레벨 스레드가 1:1관계일 수도 있고, 1:N관계일 수도 있고 그림처럼 M:N 관계일 수도 있습니다.

간략적으로 봤는데도 다양한 용어와 개념들로 인해 굉장히 복잡합니다. 지금은 느낌만 알면 됩니다. 당장에 더 자세히 알고 싶다면 인터넷에 검색해도 되나 완전히 이해하기에는 지금은 쉽지 않으실 겁니다. 용어에 익숙해지고 여유가 생긴다면 그때 추가적인 지식을 쌓아도 됩니다.

그럼 이제 자바의 Thread에 대해서 알아봅시다.


## Java Thread

Java8 기준으로 Java의 Thead는 사용자 레벨 스레드를 사용하지 않습니다.
(이전에는 Green Thread라는 사용자 레벨 스데르를 지원하긴 했습니다.)


Java Virtual Machine을 통해 운영체제로 시스템 콜을 호출하여 Kernel Thread를 할당 받습니다.

Windows 운영체제에서는 Windows Thread를 할당 받고, BSD 계열에서는 POSIX Thread, 리눅스 계열에서도 POSIX Thread를 할당 받습니다.


즉, 자바에서 Thread 인스턴스를 생성 후, thread.start() 메서드를 호출하면 JVM은 운영체제에게 커널 레벨 스레드를 요청하며, 자바의 스레드와 커널 레벨 스레드와 1:1 매팅됩니다.

그리고 커널 레벨 스레드는 윈도우, 유닉스/리눅스, Mac 각각 설정, 컴퓨터 환경에 따라서 최대 몇 개의 스레드를 생성할 수 있는지 다릅니다.

```

public static void main(String[] args) {

  ...
  Thread thread = new Thread(runnalbe);
  // start() 메서드가 호출되면 그제서야 Kernel Thread를 요청한다.
  thread.start();

}

```
자바의 Thread를 얘기하기 위해 CPU와 Core와 CPU 스케줄링과, Process와 Hardware Thread, Kernel Level Thread, User Thread가 어떤 관계인지 굉장히 간략하게 살펴봤고, 적은 수의 Core로 수많은 Task를 실행해야 하는 어려움도 살펴봤습니다.


일단 커라단 그림을 머릿속에 넣었으면 세부적인 내용은 앞으로 하나씩 채워나가면 됩니다.


4\. Thread를 많이 사용한다고 좋은 것은 아니다.
---

우리는 이전 강의 "스레드는 종잡을 수 없다"에서 Thread를 이용하여 0에서 10억까지의 수를 더했을 때 값은 얼마인지 구하는 법에 대해 예시를 확인해 봤습니다.


### 예제 코드
```

public class Person implements Runnable {

  public long sum = 0;
  private final long from;
  private final long to;

  public Person(long from, long to) {
    this.from = from;
    this.to = to;
  }

  public void run() {

    for (long i = from; i <= to; i++) {
      if(0 == i % 2) {
        sum += i;
      }
    }
  
  }

}

public static void main(String[] args) {
  try {
    long startTime = System.currentTimeMills();
    Person person1 = new Person(0, 500000000);
    Thread threadA = new Thread(person1);
    Person person2 = new Person(500000001, 1000000000);
    Thread threadB = new Thread(person2);

    threadA.start();
    threadB.start();

    threadA.join();
    threadB.join();

    System.out.println(person1.sum + person2.sum);
    long endTime = System.currentTimeMills();
    System.out.prinln(endTime - startTime);
    
  } catch (InterrruptedException e) {}
}

```

Thread를 이용하면 연산이 항상 빠를 것이라고 생각할 수 잇지만, 특정상황에서는 오히려 Single Thread를 이용하는 것보다 더 느릴 수 있습니다.

우리는 조금 전 Core와 커널 스레드에 대해서 살펴보았으며, Java의 스레드는 커널 스레드를 사용한다고 했었고, Core라는 자원은 유한하나 Task의 수는 많을 수 있다고 했으며 Task를 처리하는 방법으로 사람으로 따지면 멀티플레이 방법을 얘기했었습니다.

멀티플레이의 단점은 중요하고 빨리 끝내야 하는 일이 다른 일을 하느라 늦게 처리될 수 있으며, 일을 번갈아 가면서 한다는 것은 이전에 했던 일을 기억해야 한다는 점과 집중력이 저하된다고 했었습니다.

이러한 문제는 컴퓨터도 동일합니다. 운영체제에서도 한정된 Core를 이용하여 여러 Kernel Thread를 관리하는 방식은 인간의 멀티플레이와 유사한 부분이 있습니다.


Core의 개수가 하나, 일하고 있는 Kernel Thread A,B 두 개라고 가정합니다.

  1. Kernel Thread A의 작업을 실행하다가 중간에 Kernel Thread B로 넘어갑니다.
  2. 넘어가기 전에 Kernel Thread A의 작업 내용을 어디서부터 다시 시작해야 하는지 저장하고  Kernel Thread B로 넘어갑니다.
  3. Kernel Thread B의 작업을 실행하다가 Kernel Thread B의 작업 내용을 어디서부터 다시 시작해야 하는지 저장하고 Kernel Thread A로 넘어갑니다.
  4. Kernel Thread A의 이전에 작업했던 내용을 읽은 후 시작해야 할 부분부터 다시 실행합니다.
  5. 이 과정을 작업이 끝날 때까지 반복합니다.

이렇게 Kernel Thread를 옮겨가며 작업하는 것을 Context Switching이라고 하며 들어가는 비용을 Context Switching Cost라고 합니다.


Thread를 옮겨가는 것만으로 저장, 읽기 연산이 계속 반복되며 들어가는 비용입니다.

그리고 생각보다 이 비용은 굉장히 비쌉니다.

만약에 Single-Core 컴퓨팅 환경에서 Single-Thread 연산이 아닌, Multi-Thread 연산을 하게되면, Single-Thread 보다 더 큰 비용이 들어갑니다.

그리고 해당 예제 코드에서 발생하는 추가적인 비용은 다음과 같습니다.

  1. Thread 인스턴스 2개 생성 비용
  2. thread.start() 메서드 시점에 Kernel Thread를 생성하는 비용
  3. 연산시 Context Switching Cost

그러므로 간단한 연산은 Single-Thread 환경에서 연산하는 것이 훨씬 낫습니다.


---