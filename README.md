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
    
    
  
  

