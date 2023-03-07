import tree.NormalTree;

public class Mian {

  public static void main(String[] args) { 
    NormalTree normalTree = new NormalTree();

    for(int i=0; i<12; i+) {
      normalTree.add(i+1);
    }

    normalTree.printTree();
    System.out.pritnln("traversal");
    normalTree.levelOrder();
    
  }
  
}