package Splay;

import Trees.MyBinarySearchTree;

public class SplayTree {

    private MyTreeNode root;

    public SplayTree() {
        this.root = null;
    }

    // convenience function for testing
    public Integer root() {
        return root.getData();
    }

    // - copied from BinarySearchTree for convenience
    // - !not correct splay add
    public void add(Integer data) throws Exception {
        this.root = add(root, data);
    }

    private MyTreeNode add(MyTreeNode node, Integer data) throws Exception {
        if (node == null) {
            return new MyTreeNode(data);
        } else if (node.getData().equals(data)) {
            throw new Exception("Item is already in the tree");
        }

        if (data < node.getData()) {
            node.setLeft(add(node.getLeft(), data));
        } else if (data > node.getData()) {
            node.setRight(add(node.getRight(), data));
        }
        return node;
    }

    public boolean splay(Integer data) {
        // returns true if found, false otherwise
        return splay(root, data);
    }

    private boolean splay(MyTreeNode root, Integer data) {
        if (root == null) {
            return false;
        } else if (data == root.getLeft().getData()) {
            return true;
        } else if (null == root.getRight().getData()) {
            return true;
        }else{
            if (data > root.getData()) {
                return splay(root.getRight(), data);
            }else if (data < root.getData()){
                return splay(root.getLeft(), data);
            }
        }
        return false;
    }

    public MyTreeNode leftRotate(MyTreeNode node){
        MyTreeNode x = node.getRight();
        node.setRight(x.getLeft());
        x.setLeft(node);

        return x;
    }

    public MyTreeNode rightRotate(MyTreeNode node){
        MyTreeNode x = node.getLeft();
        node.setLeft(x.getRight());
        x.setRight(node);

        return x;
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


    private class MyTreeNode {
        private Integer data;
        private MyTreeNode left;
        private MyTreeNode right;

        public MyTreeNode(Integer data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public MyTreeNode(Integer data, MyTreeNode left, MyTreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
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

    }
}