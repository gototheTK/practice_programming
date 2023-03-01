public class Main {

  static class ThreadTest implements Runnable{

    private String name;
    private Integer count;

    public ThreadTest(String name, Integer count){

      this.name = name;
      this.count = count;
      
    }

    public void run() {

      int result = 0;

      int count = this.count.intValue();

      for(int i = 0; i< count; i++) {

        result +=1;
        
      }

      System.out.println(this.name +":" + result);
      
    }

    
  }

  public static void main(String[] args) {

    try {
        
        Thread test1 = new Thread(new ThreadTest("A", 100000000));
        Thread test2 = new Thread(new ThreadTest("B", 10000000));
        
        test1.setDaemon(true);
        test2.setDaemon(true);
    
        test1.start();
        test2.start();
        
        test1.join();
        test2.join();
        
    } catch (InterruptedException e) {
        e.printStackTrace();
    } 
    
    
  }
  
}