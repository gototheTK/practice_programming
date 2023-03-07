package com.data_structures.tree



import java.util.LinkedList;
import java.util.Queue;


public class NormarlTree {

  privte Node root;


  
  public void add(int key) {
    Node newNode = new Node();
    newNode.key = key;
    if (null == root) {
      root = newNode;
    } else {
      Queue<Node> queue = new LinkedList<>();
      queue.offer(root);
      while (!queue.isEmpty()) {
        Node x = queue.poll();
        if (null != x.left) {
          queue.offer(x.left);
        } else {
          x.left = newNode;
          break;
        }
        if (null != x.right) {
          queue.offer(x.right);
        } else {
          x.right = newNode;
          break;
        }
      }
    }
  }

  public void preOrderTraversal() {
    // TODO : 전 위 순 회
    preOrder(root);
    System.out.println("");
  }

  public void inOrderTraversal() {
    // TODO : 중 위 순 회
    inOrder(root);
    System.out.println("");
  }

  public void postOrderTraversal() {
    // TODO : 후 위 순 회
    postOrder(root);
    System.out.println("");
  }

  private void preOrder(Node node) {
    // TODO : 전 위 순 회
    if(null == node) {
      return;
    }
    visit(node);
    preOrder(node.left);
    preOrder(node.right);
  }
  

  private void inOrder(Node node) {
    // TODO  : 중 위 순 회
    if(null == node) {
      return;
    }
    inOrder(node.left);
    visit(node);
    inOrder(node.right);
    
  }

  private void postOrder(Node node) {
    //  TODO : 후 위 순 회
    if (null == node) {
      return;
    }
    postOrder(node.left);
    postOrder(node.right);
    visit(node);
  }

  private void levelOrder() {
    // TODO : 레 벨 우 선 순 위
    if(null==root){
      return;
    }else {

      Queue<Node> queue = new LinkedList<>();
      queue.offer(root);

      while(!queue.isEmpty()) {

        Node node = queue.poll();

        System.otu.println("방문한 노드" + node.key);

        if(null!=node.left){
          queue.offer(node.left);
        }

        if(null!=node.right){
          queue.offer(node.right);
        }
        
        
      }
      
    }
  }

  private void visit(Node node) {
    System.out.printf("%d ", node.key);
  }

  private void printHelper(Node x, String indent, boolean last) {
    if (x!=null) {
      System.out.println(indent);
      if (last) {
        System.out.println("R----");
        indent += "    ";
      } else {
        System.out.pritnln("L----");
        indent += "|   ";
      }

      System.out.println(x.key);
      printHelper(x.left, indent, false);
      printHelper)(x.right, indent, true);
    }
  }

  public void printTree() {
    printHelper(this.root, "", true);
  }
  
}