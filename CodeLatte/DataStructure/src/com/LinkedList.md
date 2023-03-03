# 연결리스트



1\. 단일연결리스트
---

 목차
 ---

1. [심화] 구현된 코드를 더 고도화해보자
2. [심화] 다르 방식의 단일 연결리스트


1. [심화] 구현된 코드를 더 고도화해보자.
---

기존에 구현된 SingleLinkedList는 모든 Object를 저장할 수 있는 구조로 되어있습니다. 이러한 구조는 'Java로 배우는 프로그래밍<제네릭>' 강의에서 설명했지만 두 가지 큰 문제가 있습니다.

  1. 데이터를 저장 후에는 리스트에 어떤 자료형의 데이터를 저장했는지 알 수 없다. (instanced로 하나씩 확인해야함)

  2. 개발자의 실수로 하나의 리스트에 서로 다른 이질적인 데이터를 저장 후 데이터를 꺼낼 때 형 변환 코드를 잘못 작성하면 ClassCastException이 발생할 수 있다.

예시코드
---
```

  SinglyLinkedList list = new SinglyLinkedList();

  list.addLast("안녕");
  list.addLast(1);
  list.addLast(true);

  Integer data = (Integer) list.getData(0);
  // ClassCastException 발생

```
그래서 컴파일 단계에서 자료형을 체크할 수 있는 도구인 Generic을 사용하여 코드의 안정성을 더 높일 수 있습니다.


### Main.java

```

class Node<E> {
  Node<E> next;
  E data;
}

```

SinglyLinkedList.java

```
class SinglyLinkedList<T> {
  Node<T> head = null;
  int size = 0;
  
  
  private Node<T> findNode(int searchIndex) {
    ...
  }
  
  public T getData(int searchIndex) {
    ...
  }
  
  public void add(int index, T data) {
    ...
  }
}

```

Main.java

```
SinglyLinkedList<String> list = new SinglyLinkedList<>();

list.addLast("A");


// incompatible 컴파일 에러 발생
list.addLast(1);

```

실습도구에 있는 코드를 실행해보고 확인해보세요.(generic_list 패키지입니다.)


2\. [심화] 다른 방식의 단일 연결 리스트
---

강의의 내용에서 head는 단순히 첫 번째 노드의 참조값을 저장하는 변수로 얘기했었는데요. 데이터가 존재하지 않는 head 노드를 만드는 방식도 있습니다.

