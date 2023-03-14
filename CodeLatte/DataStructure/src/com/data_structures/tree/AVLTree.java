package com.data_structures.tree


class Node {
  int key;
  int height;
  Node left;
  Node right;

  public Node(int key) {
    this.key = key;
  }
  
}

public class AVLTree {

  private Node root;

  public void add(int key) {

    Node newNode = new Node(key);

    if(null==root) {
      root = newNode;
    } else {
      root = insertNode(root, newNode);
    }
    
  }

  private Node insertNode(Node x, Node newNode) {

    if (null==x) {
      x = newNode;
    } else if (x.key > newNode.key) {
      x = insertNode(x.left, newNode);
    } else {
      x = insertNode(x.right, newNode);
    }
    return x;
  }

  public void remove(int key) {
    root = removeNode(root, key);
  }

  private Node removeNode(Node root,int key) {
    
    if (root.key > key) {
      root = removedNode(root.left, key);
    } else if (root.key < key) {
      root = removedNode(root.right, key);
    } else {

      if(null!=root.left) {

        Node predecessor = getLargestNode(root.left);
        int removeKey = root.key;
        root.key = predecessor.key;
        predecessor.key = removeKey;
        root.left = removedNode(root.left, key);
        
      } else if(null!=root.right) {
        
        Node successor = getSmallestNode(root.right);
        int removeKey = root.key;
        root.key = successor.key;
        successor.key = removeKey;
        root.right = removedNode(root.right, key);
        
      } else {
        root = null;
      }
      
    }

    return root;
    
  }

  private Node rotate(Node x) {

    int xNodeBalance = getBalance(x);

    if (Math.abs(xNodeBalance >= 2) {

      if (xNodeBalance > 1 && 0 <= getBalance(x.left)) {
        x = LL_rotate(x);
      } else if (xNodeBalance > 1 && -1 == getBalance(x.left)) {
        x.left = RR_rotate(x.left);
        x = LL_rotate(X);
      } else if(xNodeBalance < -1 && 0 >= getBalance(x.right)) {
        x = RR_rotate(x);
      } else if(xNodeBalance < -1 && 1 == getBalance(x.right)) {
        x.right = LL_rotate(x.right);
        x = RR_rotate(x);
      }
    }

    return x;
    
  }

  private Node getLargestNode(Node x){
    if(null == x.right){
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

  public int search(int key) {
    return searchNode(root, key).key;
  }

  private Node searchNode(Node x, int key) {
    Node node = x;
    if (null == node) {
      throw new RuntimeException(" 키 를 찾 을 수 없 습 니 다.");
    } else if (node.key > key) {
      node = searchNode(x.left, key);
    } else if (node.key < key) {
      node = searchNode(x.right, key);
    }
    return node;
  }
  

  private Node LL_rotate(Node P) {
    Node L = P.left;
    Node LR = L.right;
    L.right = P;
    P.left = LR;

    changeNodeHeight(P);
    changeNodeHeight(L);

    return L;
    
  }

  private Node RR_rotate(Node P) {

    Node R = P.right;
    Node RL = R.left;
    R.left = P;
    P.right = RL;

    changeNodeHeight(P);
    changeNodeHeight(R);

    return R;
    
  }

  private int getHeight(Node x) {
    int leftChildHeight = (null != x.left) ? x.left.height : -1;
    int rightChildHeight = (null != x.right) ? x.right.height : -1;
    return Math.max(leftChildHeight, rightChildHeight) +1;
  }

  private int getBalance(Node x) {
    int leftChildHeight = (null != x.left) ? x.left.height : -1;
    int rightChildHeight = (null != x.right) ? x.right.height : -1;
    return leftChildHeight - rightChildHeight;
  }

  private void changeNodeHeight(Node x) {
    x.height = getHeight(x);
  }

  
}