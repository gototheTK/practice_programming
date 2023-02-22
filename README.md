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
      BEVERAGE(2500, "음료")

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
    


