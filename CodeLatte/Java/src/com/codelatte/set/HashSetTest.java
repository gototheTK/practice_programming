import java.util.HashSet;

public class HashSet{

  public static void main(String[] args) {

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
    
  }
  
}