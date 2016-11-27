package Trees;

public class MyBinarySearchTree {

  private MyTreeNode root;
  private int size;

  public MyBinarySearchTree() {
    this.root = null;
    size = 0;
  }

  public void add(Integer data) {
    this.root = add(root, data);
  }

  private MyTreeNode add(MyTreeNode root, Integer data) {
    if (root == null) {
      return new MyTreeNode(data);
    } else if (root.getData() == data) {
      throw new IllegalArgumentException("No duplicates!");
    } else{
      if (data < root.getData()) {
        root.setLeft(add(root.getLeft(), data));
      }
      if (data > root.getData()){
        root.setRight(add(root.getRight(), data));
      }
    }
    return root;
  }

  public void remove(Integer data) throws Exception{
    root = remove(root, data);
  }

  private MyTreeNode remove(MyTreeNode node, Integer data) throws Exception {
      if (node == null) {
          return null;
      } else if(node.getData() == data) {
          if(node.getRight() == null && node.getLeft() == null) {
              return null;
          } else if(node.getLeft() == null){
              node = node.getRight();
          } else if(node.getRight() == null) {
              node = node.getLeft();
          } else {
              MyTreeNode succ = succ(node);
              node.setRight(remove(node.getRight(), node.getRight().getData()));
              node.setData(succ.getData());
          }
     } else if (data > node.getData()) {
          node.setRight(remove(node.getRight(), data));
      } else if (data < node.getData()) {
          node.setLeft(remove(node.getLeft(), data));
      }
     return node;
  }

  private MyTreeNode succ(MyTreeNode node) {
    if (node == null) {
      return null;
    }
    return min(node.getRight());
  }

  private MyTreeNode min(MyTreeNode node) {
    if (node == null) {
      return null;
    } else if (node.getLeft() == null) {
      return node;
    } else {
      return min(node.getLeft());
    }
  }




  public String toString() {
    return toString(root);
  }

  private String toString(MyTreeNode root) {
    if (root == null) {
      return "";
    } else {
      return toString(root.getLeft()) + root.getData() + " " + toString(root.getRight());
    }
  }

  public boolean contains(Integer data) {
    return contains(root, data);
  }

  private boolean contains(MyTreeNode root, Integer data) {
    if (root == null) {
      return false;
    } else if (root.getData() > data) {
      return contains(root.getLeft(), data);
    } else if(root.getData() < data)  {
      return contains(root.getRight(), data);
    } else {
      return true;
    }
  }

  public int size() {
    return size;
  }

  private class MyTreeNode {
    private Integer data;
    private MyTreeNode left;
    private MyTreeNode right;
    private MyTreeNode parent;

    public MyTreeNode(Integer data) {
      this.data = data;
      this.left = null;
      this.right = null;
      this.parent = null;
    }

    public MyTreeNode(Integer data, MyTreeNode left, MyTreeNode right, MyTreeNode parent) {
      this.data = data;
      this.left = left;
      this.right = right;
      this.parent = parent;
    }

    public Integer getData() {
      return data;
    }

    public void setData(Integer data) {
      this.data = data;
    }

    public MyTreeNode getLeft() {
      return left;
    }

    public void setLeft(MyTreeNode left) {
      this.left = left;
    }

    public MyTreeNode getRight() {
      return right;
    }

    public void setRight(MyTreeNode right) {
      this.right = right;
    }

    public MyTreeNode getParent() {
      return parent;
    }

    public void setParent(MyTreeNode parent) {
      this.parent = parent;
    }

  }
}