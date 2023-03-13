


public class BinarySearchTree {

    private Node root;

    public void add(int key) {

      Node newNode = new Node();
      newNode.key = key;
      if (null == root) {
        root = newNode;
      } else {
        root = insertNode(root, newNode);
      }
    }

    private Node insertNode(Node x, Node newNode) {

      if (null == x) {
        return newNode;
      } else if(x.key > newNode.key) {
        x.left = insertNode(x.left, newNode);
      } else {
        x.right = insertNode(x.right, newNode);
      }
      return x;
    
    }

    public void remove(int key) {
      root = removeNode(root, key);
    }

    private Node removeNode(Node x, int key) {

      if (null == x) {
        throw new RuntimeException("노 드 를 찾 을 수 없 습 니 다.");
      } else if (x.key > key) {
        removeNode(x.left, key);
      } else if (x.key < key) {
        removeNode(x.right, key);
      } else {

        if(null != x.left) {
          Node predecessor = getLargestNode(x.left);
          int removeKey = x.key;
          x.key = predecessor.key;
          predecessor.key = removeKey;
          x.left = removeNode(x.left, key);
        }else if(null != x.right) {
          Node successor = getSmallestNode(x.right);
          int removeKey = x.key;
          x.key = successor.key;
          successor.key = removeKey;
          x.right = removeNdoe(x.right, key);
        } else {
          return null;
        }
        
      }

      return x;
      
    }

  private Node getLargestNode(Node x) {
    if(null == x.right) {
      return x;
    }
    return getLargestNode(x.right);
  }

  private Node getSmallestNode(Node x) {
    if(null == x.left) {
      return x;
    }
    return getSmallestNode(x.left);
  }

  public int searc(int key) {
    return searchNode(root, key).key;
  }

  private Node searchNode(Node x, int key) {
    Node node = x;
    if(null == node) {
      throw new RuntimeException("노 드 를 찾 을 수 없 습 니 다.");
    } else if(node.key > key) {
      node = searchNode(node.left, key);
    } else if(node.key < key) {
      node = searchNode(node.right, key);
    }

    return node;
  }
  
}