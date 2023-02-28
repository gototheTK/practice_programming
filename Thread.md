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

현실 세계에서는 한 사람이 일을 하는 것보다 두 사람이 일을 하면 많은 양의 일을 더 빨리 끝낼 수 있는데요. 컴퓨터의 세계도 동일합니다. 하나의 스레드가 일하는 것보단 두 스레드 이상이 일을 할 때 더 빨리 끝낼 수도 있습니다.


평범한 세 사람이 있습니다. 한 명은 A 팀이고 두 명은 B팀입니다. 그리고 각 팀에게 0에서부터 10억까지의 수 중에서 짝수만 더한 합을 구하는 과제를 줬습니다. 과연 어느 팀이 더 빠르게 문제를 해결할 수 있을까요?


### Thread

### 프로그램이 실행된 상태를 프로세스(Process)라고 부르며 프로세스 내의 자원을 사용하여 실행되는 흐름의 단위를 스레드(Trhead)라고 합니다.

프로그램은 하나 또는 그 이상의 프로세스로 운영될 수 있으며 하나의 프로세스는 하나 또는 그 이상의 스레드로 운영될 수 있습니다. 일반적인 자바 프로그램은 하나의 프로세스와 하나의 스레드로 운영되나 앞으로 우리가 다루게 되는 여러 소프트웨어들은 대부분 멀티 스레드 방식으로 실행됩니다.

우리가 여태까지 만들었던 프로그램들은 자바 프로그램의 메인 실행 흐름을 담당하는 하나의 메인 스레드(Main Thread) 만으로 프로그램을 실행했었습니다. 그러나 이번 강의에서는 하나의 스레드만 사용하는 것이 아니라 여러개의 스레드를 이용하여 프로그램을 실행할 겁니다.


### 하나의 스레드를 사용하여 0에서 10억까지의 짝수를 더하는 프로그램


```
public class Mian {

  public static void main(String[] args) {
      long startTime = System.currentTimeMills();
      long sum = 0;

      for (long i = 0; i <= 1000000000; i++) {
        if(i % 2 == 0) {
          sum += i;
        }
      }

      System.out.println(sum);
      long endTime = System.currentTimeMillis();
      System.out.println("걸린시간: " + (endTime - startTime));
      
  }

}

```

우리는 코드를 변형하여 두 개의 스레드가 계산하도록 할 겁니다.


### 스레드를 사용하기 위한 준비

먼저 스레드를 생성하기에 앞서 스레드에게 전달할 작업을 만들어줘야 합니다. 스레드는 Runnable 인터페이스를 구현한 클래스를 전달받을 수 있으며, Runnable를 전달받고 스레드를 실행하면 Runnable의 추상 메서드인 run() 메서드를 실행합니다.

```
package java.lang;

public interface Runnable {
  public abstract void run();
}
```

```
public class Task implements Runnable {
  public void run() {
    // 스레드가 실행할 작업
  }
}

```

스레드가 실행되면 run() 메서드가 실행되므로 어떻게 0에서 10억까지 짝수의 합을 더할지 작업을 나눠봐야 합니다.

메인 스레드가 A 스레드와 B 스레드에게 각각의 작업을 실행하도록 명령할 겁니다. A 스레드는 0에서 5억까지의 짝수의 합을 더하고 B 스레드는 5억 1에서 10억까지 짝수의 합을 더합니다. 그리고 최종적으로 두 스레드의 작업이 끝나면 두 스레드가 계산한 값을 합하면 0에서 10억까지의 짝수의 합을 구할 수 있습니다.

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

```

Task 생성자를 통해 어디에서부터 어디까지 계산할 것인지 계산 범위를 전달받습니다. 그리고 스레드가 Runnable의 run() 메서드를 실행하면 짝수만 구해서 sum 변수에 저장할 겁니다. 계산이 완료되면 이후에 getSum() 메서드를 통해서 계산 결과를 가져올 수 있습니다.


### 스레드의 생성과 실행

스레드를 생성하는 것은 어렵지 않습니다. 스레드의 생성자는 Runnable 인터페이스를 구현한 객체만 전달받을 수 있습니다.

```

  Thread thread = new Thread(Runnalbe 구현 겍체만 가능);
  thread.start();

```

그리고 start() 메서드가 호출되면 Runnable의 run() 메서드를 실행합니다.

```

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

```

이렇게 두 개의 작업과 각 작업을 맡을 스레드를 생성하고 실행해봅니다.

### 출력

```

123  // 다른 값이 나올 수도 있음

```

출력 결과를 보면 생각지 못한 값이 나옵니다. 적어도 몇 억은 돼야 할 텐데 이상한 값이 출력됩니다.

이 이유는 스레드는 병렬적으로 실행되고 비동기적으로 작업이 완료되기 때문입니다.


2\. 동기적, 비동기적, 병렬적
---

### 동기적

스레드의 실행 흐름을 알기 위해서는 동기적 비동기적이라는 의미를 알아야 합니다. 여태까지 우리가 작성했던 코드는 메인 스레드에 의해 동기적으로 실행됐습니다.

얼마나 걸리든 간에 순서대로 한 줄씩 코드를 실행하며 이전 작업이 끝나야지 새로운 작업을 하고 모든 할 일을 마치고 나서야 프로그램이 종료되었습니다.

결론적으로 위에서부터 아래로 순차적으로 코드를 실행했습니다.

이렇게 선 작업이 종료될 때까지 기다린 후 다음 작업을 수행하는 것을 동기적이라고 부릅니다.


### 비동기적

비동기적은 이전 작업이 종료될 때까지 기다리는 것이 아니라 실행 명령만 내리고 다음 작업을 실행하는 것을 비동기적이라고 합니다. 위에 있는 0에서 10억까지의 짝수의 합을 구하는 코드에서 메인 스레드는 두 스레드를 생성하고 두 스데르를 실행시킨 후 바로 밑에 있는 계산 결과를 출력하는 코드를 실행시킵니다.


결론적으로 두 스레드가 계산이 끝나기 전에 계산 결과를 출력하므로 원하는 값이 나오지 않는 겁니다.


### 병렬적

병렬적은 해당 시점에 실행 흐름이 동시에 실행되고 있는 것을 말합니다. 병렬적인 연산 방식을 하는 이유는 단시간 내에 많은 양의 계산을 하기 위해서이며 하나씩일을 처리하는 것보다 여러 사람이 동시에 일을 끝내면 더 빨리 끝내듯이 병렬적인 연산을 통해 단시간 내에 더 많은 작업을 빠르게 끝낼 수 있도록 합니다.


이러한 병렬적인 연산의 특징은 시작의 순서와 상관없이 끝나는 순서를 통제할 수 없습니다. 상대적으로 작업이 적을 수록 더 빨리 끝납니다.


3\. 비동기적 문제 해결하기(간단)
---

0에서 10억까지의 짝수의 합을 구하는 코드의 핵심적인 문제는 A,B 두 스레드가 작업이 끝나기전에 메인 스레드가 결과값을 출력하는 것입니다.

이 문제를 해결하기 위해서는 메인 스레드가 두 스레드의 작업이 끝날 때까지 기다릴 수 있도록해야 합니다.

thread.join()

thread의 인스턴스 메서드인 join() 메서드는 join() 메서드를 호출하는 스레드를 기다리도록 합니다. (이후에 더 자세히 배웁니다.) 그리고 join() 메서드는 checked exception 메서드이므로 반드시 예외 처리가 되어야 컴파일됩니다.

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
  
} catch (InterruptedException e) {
  e.printStackTrace();
}

```

메인 스레드는 A, B스레드를 실행 후 join() 메서드를 만나면 해당 스레드가 작업이 끝나기까지 기다립니다. 가장 먼저 threadA.join() 메서드를 만나면 메인 스레드는 A 스레드의 작업이 끝나기까지 기다리다가 A스레드의 작업이 끝나면 아래의 threadB.join()메서드를 만납니다. 다시 메인 스레드는 B 스레드의 작업이 끝나기까지 기다리다가 B 스레드의 작업이 끝나면 아래의 명령어로 흐름이 진행됩니다.


이 상황에서 A 스레드의 작업이 더 빨리 끝날 수도 있고, B 스레드가 작업이 더 빨리 끝날 수도 있으나 A가 완료되고 B가 완료되든, B 먼저 완료되고 이후에 A가 완료되든 메인 스레드는 결과론적으로 두 스레드의 작업이 끝나야지 아래의 명령어를 실행합니다.


그러므로 출력되는 결과는 다음과 같습니다.


출력
```
250000000500000000
```

이 결과는 프로그램을 여러 번 실행하더라도 동일한 값을 반환합니다.

---

4\. Daemon Thread
---
Thread를 Daemon Thread로 실행할 수 있는데요. Daemon Thread는 Main Thread가 종료되면 Sub Thread의 작업이 끝나지 않았더라도 같이 종료되는 스레드입니다.

Thread를 Deamon Thread로 사용하기로 설정

```

Thread thread = new Thread(runnable);
thread.setDaemon(true);

```
thread.start() 하기 전에 설정되어야 합니다.

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

```

```

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
  }

}

```

출력

```

Main Thread는 일을 마쳤다.
또는
Main Thread는 일을 마쳤다.
thread A: 4950
또는
Main Thread는 일을 마쳤다.
thread A: 4950
thread B: 4950

```


