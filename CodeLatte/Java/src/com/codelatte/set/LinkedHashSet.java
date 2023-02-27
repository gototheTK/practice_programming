import java.util.LinkedHashSet;


public class LinkedHashSet{


  public static void main(String[] args) {

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
    
  }

}