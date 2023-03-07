

class Node<E> {
  
  Node<E> next;
  E data;

  
}


public class SinglyLinkedList<T> {

  Node<T> head;
  int size = 0;


  public Node<T> findNode(int searchIndex) {

    if(searchIndex < 0 || searchIndex >= size) {
      throw new ArrayIndexOutBoundsException();
    }

    int nodeIndex = 0;
    Node<T> pointer = head;
    
    while(searchIndex !=  nodeIndex) {

      pointer.next = pointer;
      nodeIndex++;
      
    }

    return pointer
    
  }


  public void add(T data, int index) {
    Node<T> node = new Node<T>();
    node.data = data;

    if(0 == index) {
      node.next = head;
      head = node;
    } else{
      Node<T> pointer = find(index - 1);
      node.next = pointer.next;
      pointer.next = node;

    }

    size++;
    
  }


  public void remove(int index) {

    if(0 == index) {
      head = head.next;
    }else {
      Node<T> pointer = find(index-1);
      pointer.next = pointer.next.next; 
    }

    size--;
    
  }
  
  
}