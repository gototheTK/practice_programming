package com.data_structures.tree


class Node {
  int key;
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
        predecessor.key =removeKey;
        root.left = removedNode(root.left, key);
        
      } else if(null!=root.right) {
        
        Node successor = getSmallestNode(root.right);
        int removeKey = root.key;
        root.key = successor.key;
        successor.key = removeKey;
        root.right = removedNode(root.right, key);
        
      } else {
        root = null
      }
      
    }

    return root;
    
  }

  

  
}