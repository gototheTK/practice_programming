# 자바

## enum

  열거형 타입(enumerated type). 서로 연관된 상수들의 집합.

    상수에 의미를 부여하면서, 전달할수 있는 인자를 제한하기 위해서 사용합니다.
    자바 가상머신에 의해 Singleton으로 생성되며, 고유의 순번과 이름이 있으고 
    각각 ordinal()과 name()으로 값을 반환합니다.
    참고로 ordinal()은 순번이 바뀌면 값이 바뀌기때문에 사용에 주의하여야 합니다.

  ```

  enum CafeFoodCategory{

    BREAD, CAKE, COFFEE, BEVERAGE
    
  }

  CafeFoodCategory.BREAD.ordinal();
  CafeFoodCategory.CAKE.ordinal();
  CafeFoodCategory.COFFEE.name();
  CafeFoodCategory.BEVERAGE.name();
    
  ```

  Enum을 다르게 정의하기

    enum 상수에 특정한 값을 정희할 수 있습니다.
    상수에 특정한 값을 지정할 때는 상수의 끝맺음에 반드시 세미콜론(;)을 작성해 주어야 합니다. 
    그리고 특정한 값의 정의에 맞게 생성자를 반드시 정의해 주어야합니다. 참고로 생성자는 기본적으로 privat
    입니다.


  ```

    enum FoodCategory {
      BREAD(2800, "빵"),
      CAKE(17000, "케이크"),
      COFFEE(4300, "커피"),
      BEVERAGE(2500, "음료");

      int price;
      String name;

      private FoodCategory(int price){
        this.price = price;
      }

      pirvate FoodCategory(String name) {
        this.name = name;
      }

      private FoodCategory(int price, String name) {
        this.pirce = price;
        this.name = name;
      }
      
    }
  
  ```
    
---

## Generic

  컴파일단계에서 정상적인 타입인지 확인하게 하여, 자료형을 파라미터처럼 사용하게 해주는 도구

    <T>처럼 <>안에 문자를 넣어서 사용하며, <T,E>처럼 컴마를 넣어 여러개의 문자를 넣어를 사용할수있습니다. 참고로, 문자를 특수문자나 키워드가 아니라면 제약이없지만, 보통은 한글자의 대문자로 표현합니다.
    위같이 정의할때 사용하는 타입을 Formal Type Parameter라고하고, 대입하여 사용하는 문자를 Actual Type Parameter라고 합니다.

    클래스, 메서드, 파라미터, 멤버변수등에 사용될수 있으며, 정적메서드를 사용할때 super(상위클래스), extends(자손클래스), ?(와일드카드)등의 키워드를 사용하여 자료형의 범위를 제한할수도 있습니다.

    아래와 같이 메서드에 사용할때, 똑같은 이름의 메서드에 타입이나 파라미터에 똑같이 사용하면 메서드오버로딩 오류가 발생합니다.
    
  ```
  Class Box<T, E> {

    public void getDate(E data){}

    public void getDate(T data){}
  
  }
  
  ```

  class 파일에는 Generic정보가 존재하며, 컴파일 후에는 Formal Type Parameter가 Object로 서술됩니다. Object로 일반화된 클래스나 Generic으로 일반화된 클래스나 작동방식은 다르지 않습니다.



---

## Collection

  자바에서 제공하는 자료구조 라이브러리이다. 

### List<E>

  순서가 있는 자료구조로 만들어진 경우는 List Interface를 구현합니다. List Interface를 구현한 클래스들은 ArrayList, LinkedList, Vector, Stack등이 존재합니다.

  1. ArrayList<E>
  
    - List 인터페이스를 구현한 순서가 있는 배열의 자료구조 객체입니다. 
    - 데이터 추가시 배열이 모두 채워지면, 새로운 배열을 만들어서 값을 복사하고, 기존 배열을 대체합니다. 또한 데이터를 중간에 삭제하면, 그 위치부터 마지막 데이터까지 데이터를 복사하며 한칸씩 이동시킵니다. 마지막 데이터가 있던 공간은 null이 채워집니다.
    - 새로운 배열을 만들거나 앞으로 복사하기 때문에, 데이터가 많을수록 접근하는 시간이 길어집니다.
    - 생성시 배열의 크기가 정해지지 않는다면, 기본 배열의 크기는 10입니다.
    - 배열의 크기가 아무리 크더라도, 데이터들의 길이를 넘는 곳에 접근하려고 하면 IndexOutOfBoundsException이 발생합니다.
    - 데이터의 양이 일관적이고 삽입, 삭제가 빈번하지 않을 경우와 접근속도가 중요할때 종종 사용합니다.

  ```

  ArrayList<String> test = new ArrayList<>();
  ArrayList<String> test = new ArrayList<>(10);

  test.add("테스트1"); // 데이터 추가시
  test.remove(0); // 인덱스로 데이터를 찾아 삭제시
  test.add("테스트2");
  test.remove("테스트2"); // 데이터를 찾아서 삭제시
  test.size(); // 데이터의 길이
  test.add("테스트3");
  test.set(0,"데스트4"); // 데이터 변경시
  test.get(0); // 특정 데이터 접근시
  test.add(null); // 데이터의 논리적 공간을 늘릴시
  
  ```

  2. LinkedList

  데이터와 다음 연결 위치를 가리키는 노드라는 객체들의 연결로 이루어진 자료구조입니다.

    - 삽입과 삭제가 빠릅니다.
    - 처음부터 하나씩 거처가며 확인하기때문에, 데이터가 많아지면 많아질수록 데이터에 접근이 느려집니다.
    - 데이터의 삽입, 삭제가 많은 처리에 어울리는 자료 구조입니다.
    - 추가, 삽입, 접근, 삭제 모두 논리적인 자료의 길이를 넘어가면 인덱스 오류를 발생 시키므로 주의하여야 합니다.


  ```
  import java.util.LinkedList;

  LinkedList<String> test = new LinkedList<>();

  test.add("1");
  test.add("2");
  test.add("3");
  test.add("4");

  test.remove(1);
  test.remove("3");
  test.removeFirst();
  test.removeLast();

  test.add("딸기");
  test.get(0);
  test.set(0,"수박");

  ```

### Map<Key, Value>

  Key와 Value로 이루어진 자료구조를 구현한 자바의 자료구조 도구로써, Map을 Interface로 선언하여 HashMap, TreeMap, LinkedHashMap등을 구현하였습니다.

  1. HashMap<Key, Value>

    - Key와 Value를 HashTable이라는 자료구조를 이용하여 매핑하는 자바의 자료구조 도구입니다. 참고로, HashTable은 Key를 Hash함수로 bucket의 인덱스로 변환시켜서, bucket에 맞는 인덱스에 key와 value를 저장하는 방식의 자료구조 입니다. 즉, bucket기반의 자료구조 입니다.
    - 충분히 큰 데이터를 가지고 있을 경우, entry의 저장방식을 LinkedList 에서 TreeNode로 변경합니다.

    - 동일한 key로 저장할 경우 기존에 저장된 값이 소멸된다.(값의 중복은 상관없다.)
    - key는 대소문자를 구분한다.
    - 다양한 참조 자료형을 key로 사용할 수 있으나 index 생성 시 Object.hashCode()코드에 의존하므로 논리적으로 동일한 객체라고 하더라도 물리적으로 인스턴스가 다를 경우 Object를 key로 사용하면 원치 않는 결과가 발생할 수 있다.
      
  ```
  package hashmap;

  import java.util.HashMap;
  
  public class HashMapTest {
  
    public static void test() {
      HashMap<String, String> map = new HashMap<>();
  
      // TODO : 데이터 삽입
  
      // 데이터 삽입
      map.put("codelatte", "코드라떼");
      map.put("kantata", "김철수");
      map.put("cafe", "카페");
  
      String value1 = map.get("codelatte");
      // "코드라떼"
  
      String value2 = map.get("cafe");
      // "카페"
  
      String value3 = map.getOrDefault("coffee", "커피");
      // hashmap에 "coffee" 키가 존재하지 않을 경우 "커피"를 반환한다.
  
      // key 값을 이용하여 삭제
      map.remove("kantata");

      // key 값을 출력(정렬되어 있지 않음)
      for (String key : map.keySet()) {
        System.out.println(key);
      }

      // value값을 출력(정렬되어 있지 않음)
      for (String value : map.value()) {
        System.out.println(value);
      }

      // 동일한 key로 값을 저장하는 경우 기존에 저장된 값이 덮어쓰기가 됩니다.
      map.put("coffee", "아메리카노");
      map.put("coffee", "카페라떼");

      String value1 = map.get("coffee");

      // HashMap의 key로 Object를 사용할 시 주의해야 할 점

      private class Address {
        private String city;
        private String street;

        public Address(String city, String street) {
          this.city = city;
          this.street = street;
        }
        
      }

      // 데이터 삽입
      map.put(new Address("서울시", "강남서로 20"), "서울시 강남서로 20");
      map.put(new Address("서울시", "강남서로 20"), "서울시 강남서로 20");

      System.out.println(map);

      /** 
      의미상으로는 동일한 객체로 보일 수 있어도, 서로 다른 인스턴트이기 때문에 인스턴트의 hashcode가 다릅니다. 그러므로 두 객체는 HashMap에 중복 없이 저장됩니다.

      "모든 클래스는 Object 클래스를 상속받는다" 강의에서 같은 의미의 객체로 만들고 싶으면 Object.equals()메서드와 Object.hashCode()메서드를 재정의 해야 한다고 했었습니다.

      HashMap은 내부적으로는 해당 메서드들을 사용하기 때문에 같은 key로 만들고 싶다면 Object.equals()메서드와 Object.hashCode()메서드를 재정의 해야합니다.
      **/

      // Map 인터페이스를 구현하는 HashMap
      Map<String, String> map = new HashMap<>();

      // 다형성의 특징으로 HashMap의 참조 값을 Map 참조 자료형에 저장할 수 있습니다. 다만 Map의 공통적인 인터페이스만 선언되어 있기 때문에 HashMap의 모든 메서드를 사용할 수는 없습니다.
      
    }
    
  }
  
  ```

  2. TreeMap<Key, Value>

  - TreeMap은 Red-Black Tree를 이욯하여 만들어진 자료구조 라이브러리 입니다. (참고로, Tree는 가계 족보와 같이 Root Node를 시작으로 Node들이 계층적으로 연결되어 있는 자료구조 입니다.)

  - TreeMap에 저장될때, Key값을 기준으로, RootNode부터 시작하여 작으면 좌측하위Node, 크면 우측하위Node와 비교하여, 작지 않은 노드의 key값을 찾을때까지 반복하여 저장합니다. 만약 적지 않은 노드가 없다면 맨 하위 계층에 저장됩니다.

  - Red-Black Tree 특성상 삭제되거나 추가되면 노드들이 재배치 됩니다.

  장점
  
  - Tree구조의 자료구조이기떄문에 선형자료구조보다 자료접근이 보통 빠릅니다.
    
  - key 값을 기준으로 오름차순으로 정렬된 Key값들을 반환할 수 있습니다.

  - HashMap 대비 필요한 양의 메모리를 사용하므로, 상대적으로 HashMap보다 메모리를 절약할 수 잇습니다.

  단점
  
  - 삽입이나 삭제시 Node들을 재배치해하고, 접근할때 검색속도가 HasMap보다는 상대적으로 느립니다.
  - Key값으로 null값을 허용하지 않습니다.

  사용용도
  
  - 데이터의 양이 예상가능하지 않거나 삭제, 삽입이 비번하며 정렬된 key값이 필요할때 주로 사용합니다.
  
  주의할점 (HashMap과 동일)
  
  - Key의 중복을 허용하지 않으며, 문자일경우 대소문자를 구별합니다.
  - 참조자료형으로 Key값을 구성할 경우, 논리적인 값은 같더라도 물리적인 값이 다르라면 같은 key로 인식합니다. 즉, 인스턴트가 같지 않다면, 서로 다른 key값으로 인식합니다.

  TreeMap의 생성
  ```
    import java.util.TreeMap;

    TreeMap<Key,Value> map = new TreeMap<>();
  ```

  TreeMap의 데이터 접근

    HashMap과 마찬가지로 데이터에 접근하는 방법은 get이라는 메서드로 접근하고, getOrDefault(Object key, Object value)를 이용하여 저장된 값에 접근할 수 있습니다.

  예시)

  ```
  import java.util.TreeMap;

  // String key, String value
  TreeMap<String, String> map = new TreeMap<>();

  // 데이터 삽입
  map.put("codelatte", "코드라떼");
  map.put("kantata", "김철수");

  String value1 = map.get("codelatte");
  // "코드라떼"

  String value2 = map.get("cafe");
  // "카페"

  String value3 = map.getOrDefault("coffee", "커피");
  // treemap에 "coffee" 키가 존재하지 않을 경우 "커피"를 반환한다.

  ```

  TreeMap의 Key값과 Value값을 출력

  - Map의 key와 value를 추출하면, 각각 오름차순으로 정렬되어 추출됩니다.

  ```
  import java.util.TreeMap;

  // String key, String value

  // 데이터 삽입
  map.put("2", "2");
  map.put("3", "3");
  map.put("1", "1");
  map.put("4", "4");

  // ket 값을 출력
  for (String key : map.keySet()) {
    System.out.println(key);
  }

  // "1", "2", "3", "4"
    
    //  value 값을 출력
    for (String value : map.values()) {
      System.out.println(value);
    }

    // "1", "2", "3", "4"
    
  ```

  - TreeMap 역시 HashMap과 마찬가지로, key의 중복을 허가하지 않습니다. 역시 참조자료형으로 key를 사용할 시 Object.hashCode()와 Object.equals()로 key값을 생성하거나 판단하기때문에, 논리적인 값이 같더라도 물리적값이 달라 의도한 key가 중복되는 상황이 발생할 수 있습니다.

  - Map 인터페이스를 구현하였기때문에, Map의 참조자료형에 TreeMap을 인스턴스를 저장할 수있습니다. 그러나 Map의 참조자료형으로는 TreeMap의 고유 메서드는 사용할 수없습니다.

  ```
  import java.util.TreeMap;
  import java.util.Map;

  //  String key, String value
  Map<String, String>  map  = new TreeMap<>();

  ```
---
  
  3. LinkedHashMap<Key, Value>

  LinkedHashMap은 HashMap을 상속받아 만들어진 클래스이고, HashMap의 특징을 가지고 있습니다. 그러나 Node객체를 Entity객체로 감싸서 key의 저장된 순서를 보존합니다.

  장점

  - HashMap의 장점을 그대로 보존하고, HashMadp과 다르게 key의 저장된 순서에 따라 순서를 보존합니다.

  단점

  - HashMap의 단점을 그대로 보장합니다.

  사용용도

  - 저장된 Key의 값이 중요할때 사용합니다.

  LinkedHashMap의 예시

  ```
  
  import java.util.LinkedHashMap;

  // String key, String value
  LinkedHashMap<String, String> map = new LinkedHashMap<>();

  // 데이터 삽입
  map.put("2", "2");
  map.put("3", "3");
  map.put("1", "1");
  map.put("4", "4");

  // key 값을 출력
  for (String key: map.keySet()) {
    System.out.println(key);
  }

  // value 값을 출력
  for (String value: map.values()) {
    System.out.println(value);
  }
  // "2", "3", "1", "4"
  
  ```

---
---

## Collection - Set

### 1. Set<E>

  - Java에서는 인터페이스인 Collection을 상속받은 Set<E>이라는 자료구조 라이브러를 제공합니다. Set은 집합처럼 중복이 없는 데이터모음을 만들어주는 자료구조입니다.
  
  - 종류로는 HashSet, TreeSet, LinkedHashSet등이 있습니다.

### 2. HashSet<E>

  HashSet은 HashTable의 구조를 이용한 HashMap을 이용하여 만들어진 자료구조 라이브러리 입니다. 그리하여 HashMap과 특징을 공유합니다.


  특징
  - Map의 특성인 key의 중복불가를 이용합니다. 
  - 생성자와 추가 메서드를 보면 HashMap의 key값에Set의 값으로 value에는 더미객체를 저장하여 구현되어 있습니다. 즉, HashMap을 그대로 이용합니다.
  - HashMap을 이용하여 만들어져 있으므로, 값은 정렬되어 있지 않습니다.

  사용용도
  - idnex가 아닌 key값으로 데이터를 접근하는 경우에 사용합니다.
  - 삽입 삭제가 빈번하고, 데이터의 크기가 예상되는 경우에 사용합니다.

  HashSet Code)
  ```
    // 더미 Object
    public static final Object PRESENT = new Object();
  
    // HashSet의 생성자
    public HashSet() {
      map = new HashMap<>();
    }


    public HashSet(Collection<? extends E> c) {
      map = new HashMap<>(Math.max((int) (c.size() / 0.75f) + 1, 16));
    }
    
    // HashSet의 데이터 
    add(E e) {
    return map.put(e, PRESENT) == null;
    }
      
  ```

  예제)
  
  ```
  import java.util.HashSet;

  // HashSet의 생성

  HashSet<String> texts = new HashSet<>();

  // HashSet의 데이터 삽입
  
  // String value
  HashSet<String> set = new HashSet<>();

  // 데이터 삽입
  set.add("코드라떼");
  set.add("codelatte");
  

  // 메서드를 이용하여 데어티를 저장할 수 있습니다.
  HashSet.add(value)


  // HashSet 값 포함 여부 확인
  
  // 데이터 삽입
  set.add("코드라떼");
  set.add("codelatte");

  boolean isExist = set.contains("codelatte");
  // 있으면 true, 없으면 false
  

  // HashSet 값 삭제

  // 데이터 삽입
  set.add("코드라떼");
  set.add("codelatte");
  set.add("카페라떼");

  // 데이터 삭제
  set.remove("카페라떼");
  


  // Hash 값 출력

  // 데이터 삽입
  set.add("1");
  set.add("23");
  set.add("2");
  set.add("14");
  set.add("2");
  set.add("5");

  for (String value : set) {
    System.out.println(value);
  }

  // "1", "23", "2", "14", "5"
  
  ```

--- 

### 3. TreeSet<E>

TreeSet은 논리적인 Tree구조로 데이터를 저장하는 Set입니다.


Set의 특징을 가지고 있으며, 동일한 원소를 저장하더라도 저장소에는 중복된 값이 존재하지 않습니다.

또한 TreeSet은 Tree 구조를 이용한 TreeMap을 이용하여 만들어져 있습니다.

```

  // TreeSet의 생성자
  public TreeSet() {
    this(new TreeMap<E, Object>());
  }

  ...

```

TreeSet의 생성자를 보면 TreeMap을 이용하여 Set 구조를 만드는 것을 확인할 수 있습니다.

```

  // 더미 Object
  public static final Object PRESENT = new Object();

  // TreeSet의 데이터 add 메서드
  public boolean add(E e) {
    return m.put(e, PRESENT) == null;
  }
  
```

Map의 특성 중 하나인중복 Key는 존재할 수 없다는 특징을 이용하여, key를 Set의 값으로, value에는 더미 Object를 저장 방식으로 데이터를 추가합니다.

즉, TreeSet을 이해하려면 TreeMap에 대해서 먼저 알아야 합니다.



### 4. LinkedHashSet<E>

LinkedHashSet은 HashSet을 상속받아 만들어진 클래스입니다. 그러므로 HashSet과 특징을 공유합니다.

다음과 같이 HashSet을 상속받아 구현하는 것을 알수있습니다.

또한 생성할때, HashSet에서 LinkedHashMap을 이용하는 default 접근제어지시자를 가진 생성자를 super키워드로 이용합니다.

LinkedHashSet)

```
// LinkedHashSet은 HashSet을 상속 받는다.
public LinkedHashSet<E> extends HashSet<E> ...

// LinkedHashSet의 생성자
public LinkedHashSet() {
  super(16, .75f true);
}

HashSet)


// HashSet의 default 접근 제어 지시자 생성자
HashSet(int initialCapacity, float loadFactor, boolean dummy) {
  map = new LinkedHashMap<>(initialCapacity, loadFactor)
}

```




특징

- HashSet을 상속받아 LinkedHashMap을 이용하므로, LinkedHashMap의 특징을 계승합니다.

사용용도

- 값의 저장된 순서가 중요할때 사용합니다.

```

import java.util.LinkedHashSet;

// LinkedHashSet의 생성

LinkedHashSet<String> texts = new LinkedHashSet<>();


LinkedHashSet의 데이터 삽입

// 데이터 삽입
set.add("codelatte");
set.add("코드라떼");


// LinkedHashSet 값 포함 여부 확인


// 데이터 삽입
set.add("codelatte");
set.add("코드라떼");

boolean isExist = set.contains("roka");
// 있으면 true, 없으면 false


// LinkedHashSet 값 삭제


// 데이터 삽입
set.add("codelatte");
set.add("코드라떼");
set. add("카페라떼");

// 데이터 삭제
set.remove("카페라떼");

// LinkedHashSet 값 츨략

// String value
LinkedHashSet<String> set = new LinkedHashSet<>();

// 데이터 삽입
set.add("1");
set.add("23");
set.add("3");
set.add("14");
set.add("2");
set.add("5");

for(String value : set) {
  System.out.println(value);
}

// "1", "23", "3", "14", "2", "5"

```

---

### 5. [추가] 합집합, 교집합, 차집합, 여집합, 부분집합여부, 원소포함여부


자바에서 합집합, 교집합, 차집합, 부분집합 및 여부을 구현해 볼수있습니다.
합집합은 Set.addAll(Collection)
교집합은 Set.retainAll(collection)
차집합은 Set.removeAll(Collection)

집합을 추출할때, 원본의 데이터를 변경시키므로 데이터를 복사하여서 데이터를 추출해야한다.

부분집합여부는 Set.containsAll(Collection)
원소포함여부는 Set.contains(value)

A = {1, 2, 3, 4, 5}
B = {3, 4, 5, 6, 7}
C = {3, 4}


```

// A 집합
List<String> set1 = Arrays.asList("1", "2", "3", "4", "5");
TreeSet<String> A = new TreeSet<>(set1);

// B 집합
List<String> set2 = Arrays.asList("3", "4", "5", "6" ,"7");
TreeSet<String> B = new TreeSet<>(set2);

// C 집합
List<String> set3 = Arrays.asList("3", "4");
TreeSet<String> C = new TreeSet<>(set3);


// C집합이 A집합의 부분집합인지 확인 방법
boolean isContainAll = B.contains(C);
System.out.println("C ⊂ B ? " + isContainsAll);

/**
Set.containsAll(set)메서드를 이용하여 부분집합여부를 확인할 수 있습니다.
부분집합이면 true, 부분집합이 아니면 false를 반환합니다.
**/


// 원소의 포함여부 확인 방법
boolean isContain = B.contains("7");
System.out.println("7 ⊂ B ? "+ isContain);

/**
Set.contains(value)메서드를 이용하여 해당 집합에 원소가 포함되는지 확인할 수 있습니다.
원소가 포함되면 true, 원소가 포함되지 않으면 false를 반환합니다.
**/

//A교잡합 B 추출 방법
TreeSet<String> cloneA = new TreeSet<>(set1);
boolean isModified = cloneA.retainAll(B);
System.out.println("A ∩ B ? "+cloneA);

/**

Set.retainAll(collection) 메서드를 이용하여 교집합을 추출할 수 있습니다.

반환값은 cloneA 변경 여부를 반환합니다.

cloneA에 원소가 존재하지 않는 경우를 제외하고는 항상 true를 반환한다고 보시면 됩니다.

그리고 Set.retainAll(collection) 메서드는 원본의 데이터를 변경하므로, 원본의 데이터 손실을 원하지 않는다면 원본을 복사해서 사용해야 합니다.
**/

//A 합집합 B 추출 방법



TreeSet<String> cloneA = new TreeSet<>(set1);
boolean isModified = cloneA.addAll(B);
System.out.println("A U B ? " + cloneA);

/**

Set.addAll(collection) 메서드를 이용하여 합집합을 추출할 수 있습니다.

반환값은 cloneA 변경 여부를 반환합니다.

cloneA에 원소가 존재하지 않는 경우를 제외하고는 합성 true를 반환한다고 보시면 됩니다.

그리고 Set.addAll(collection) 메서드는 원본의 데이터를 변경하므로, 원본의 데이터 변경을 원하지 않는다면 원본을 복사해서 사용해야 합니다.

**/

//A 차집합 B 추출 방법(A - B)


TreeSet<String> cloneA = new TreeSet<>(set1);
boolean isModified = cloneA.removeAll(B);
System.out.println("A - B ? " + cloneA);

/**

Set.removeAll(collection) 메서드를 이용하여 차집합을 추출할 수 있습니다.

반환값은 cloneA 변경 여부를 반환합니다.

cloneA에 원소가 존재하지 않는 경우를 제외하고는 항상 true를 반환한다고 보시면 됩니다.

그리고 Set.removeAll(collection) 메서드는 원본의 데이터를 변경하므로, 원본의 데이터 변경을 원하지 않는다면 원본을 복사해서 사용해야 합니다.

**/