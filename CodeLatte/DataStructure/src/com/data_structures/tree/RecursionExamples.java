

public class RecursionExamples {

  public static void main(String[] args) {

    // TODO : 인 덱 스 출 력 하 기 1
    System.out.println("-------------");


    // TODO : 인 덱 스 합 출 력 하 기 2
    System.out.println(" 인 덱 스 의 합 : %d\n", split2(0, 7));
    System.out.println("-------------");

    // TODO : 배 열 의 값 의 합 출 력 하기 3
    int[] arr = {4, 2, 5, 1, 5, 3, 1, 2};
    System.out.println(" 배 열 의 합 : %d", sum(arr, 0, arr.length - 1));
    
  }

  public static int sum(int[] arr, int startIndex, int endIndex) {
    // TODO : 배열의 합 메서드
    if(startIndex == endIndex) {
      return arr[startIndex];
    }

    return sum(arr, startIndex, (endIndex + startIndex)/2) + sum(arr, (endIndex + startIndex)/2 + 1, endIndex);
    
  }

  public static void split1(int[] arr, int startIndex, int endIndex) {
    // TODO : 배열 인덱스 출력 메서드
    if (startIndex == endIndex) {
      System.out.println(arr[startIndex]);
      return;
    }

    int middleIndex = (startIndex + endIndex) / 2;

    split1(arr, startIndex, middleIndex) + split1(arr, middleIndex+1, endIndex);
    
  }

  public static int split2(int startIndex, int endIndex) {
    //  TODO  :  인 덱 스 합 메 서 드
    if(startIndex == endIndex) {
      return startIndex;
    }

    int middle = (startIndex + endIndex)/2;

    return split2(startIndex, middle) + split2(middle + 1, endIndex);
  }
  
}