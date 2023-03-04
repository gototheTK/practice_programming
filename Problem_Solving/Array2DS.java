import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arr) {
    // Write your code here
    
    int row = 1;
    int col = 1;
    
    List<Integer> numbers = new ArrayList<>();
    
    
    for(int i=0; i<16; i++){
        
        row = i/4 + 1;
        col = i%4 + 1;
        
        System.out.println(row + "" +col);
        
        Integer number = arr.get(row).get(col);
        
        List<Integer> top = arr.get(row-1).subList(col - 1, col + 2);
        
        number += top.get(0) + top.get(1) + top.get(2);
        
        List<Integer> bottom = arr.get(row+1).subList(col - 1, col + 2);
        
        number += bottom.get(0) + bottom.get(1) + bottom.get(2);
        
        numbers.add(number);
        
    }
    
    Collections.sort(numbers);
    
    
    return numbers.get(numbers.size()-1).intValue();
    

    }
    
    private static Integer sum(List<Integer> array) {
        
        Integer result = 0;
        
        for(Integer cell : array) {
            result += cell.intValue();
        }
        
        
        return result;
        
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}