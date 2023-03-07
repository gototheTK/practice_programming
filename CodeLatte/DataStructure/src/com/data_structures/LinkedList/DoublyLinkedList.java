

class Node<E> {

  Node<E> left;
  Node<E> right;
  E data;
  
}


public class DoublyLinkedList {

  Node<E> head;
  Node<E> tail;
  int size = 0;

  public Node<E> find(int index) {

    if(0 < index || size >= index) {
      throw new ArrayIndexOutOfBoundsException();
    }
    
    
    Node<E> pointer;

    if(size/2 > index) {
      pointer = head;
      int pointIndex = 0;
      while(pointIndex != index) {
        pointer = pointer.right;
        pointIndex++;
      }
    }else {
      pointer = tail;
      int pointIndex = size-1;
      while(pointIndex != index) {
        pointer = pointer.left;
        pointerIndex--;
      }
    }

    return pointer;
    
  }


  public void add(int data, int index) {

    Node<E> node = new Node<>();
    node.data = data;

    if(0 == index || size == index) {

      if(null == head.right && null == tail.left) {
        head.right = node;
        tail.left = node;
      }else if(index == 0) {
        node.right = head.right;
        head.left = node;
        head = node;
      }else if(index == size) {
        node.left = tail.left;
        tail.right = node;
        tail = node;
      }
      
    } else {

      Node<E> pointer = find(index);
      Node<E> previous = pointer.left;
      node.right = pointer;
      node.left = previous;
      previous.right = node;
      pointer.left = node;
      
    }

    size++;
    
  }


  public void remove(int index) {

    Node<E> pointer = find(index);
    Node<E> previous = pointer.left;
    Node<E> next = pointer.right;
    
    if (null != previous) {
      previous.right = next;
    }
    if(null != next) {
      next.left = previous;
    }
    if(0 == index) {
      head = next;
    }
    if(size-1==index) {
      tail = previous;
    }

    pointer.right = null;
    pointer.left = null;
    pointer.data = null;

    size--;

    
  }
  
  
}