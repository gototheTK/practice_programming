class NewClass {
    int newField;
    
    int getNewField() { return newField; }

    @Deprecated
    int oldField;

    @Deprecated
    int getOldField() { return oldField; }

}

/**
 * AnnotationEx2
 */
public class AnnotationEx2 {

    public static void main(String[] args) {
        
        NewClass nc = new NewClass();

        nc.oldField = 10;   //@Dereacted가 붙은 대상을 사용
        System.out.println(nc.getNewField());   //@Depreacted가 붙은 대상을 사용

    }
    
}