package AVL;

public class AVLTree {

    private MyTreeNode root;

    public AVLTree() {
        this.root = null;
    }

    public void add(Integer data) throws Exception {
        this.root = add(root, data);
    }

    private MyTreeNode add(MyTreeNode node, Integer data) throws Exception {
        if (node == null) {
            return new MyTreeNode(data);
        } else if (node.getData() == data) {
            throw new IllegalArgumentException("No duplicates!");
        } else{
            if (data < node.getData()) {
                node.setLeft(add(node.getLeft(), data));
            }
            if (data > node.getData()){
                node.setRight(add(node.getRight(), data));
            }
            node.updateHeight(node);
            node.updateBalance(node);
        }

        if (!isBalance(node)){
            if(node.getBalance() > 1 && node.getLeft().getBalance() > 1){
                return rightRotate(node);
            }
            if(node.getBalance() < -1 && node.getRight().getBalance() < -1){
                return leftRotate(node);
            }
            if (node.getBalance() < -1 && node.getRight().getBalance() > 1) {
                node.setLeft(leftRotate(node.getLeft()));
                return rightRotate(node);
            }
            if(node.getBalance() > 1 && node.getLeft().getBalance() < -1) {
                node.setRight(rightRotate(node.getRight()));
                return leftRotate(node);
            }
        }

        node.print();
        return node;
    }

    private boolean isBalance(MyTreeNode node){
        if (node.getBalance() >= 1 || node.getBalance() <= -1){
            return false;
        }else{
            return true;
        }
    }

    public MyTreeNode rightRotate(MyTreeNode node) {
        MyTreeNode nodeX = node.getLeft();
        MyTreeNode nodeY = nodeX.getRight();

        node.setLeft(nodeY);
        nodeX.setRight(node);

        nodeX.setHeight(Math.max(nodeX.getLeft().getHeight(), nodeX.getRight().getHeight()) + 1);
        node.setHeight(Math.max(node.getLeft().getHeight(), node.getRight().getHeight()) + 1);

        return nodeX;
    }

    public MyTreeNode leftRotate(MyTreeNode node) {
        MyTreeNode nodeY = node.getRight();
        MyTreeNode nodeX = nodeY.getLeft();

        node.setRight(nodeX);
        nodeY.setLeft(node);

        node.setHeight(Math.max(node.getLeft().getHeight(), node.getRight().getHeight()) + 1);
        nodeY.setHeight(Math.max(nodeY.getLeft().getHeight(), nodeY.getRight().getHeight()) + 1);

        return nodeY;
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

    private void print() {
        if (root != null) {
            root.print();
        }
    }


    private class MyTreeNode {
        private Integer data;
        private MyTreeNode left;
        private MyTreeNode right;
        private int height;
        private int balance;

        public MyTreeNode(Integer data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.height = 1;
            this.balance = 0;
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

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

        public void print() {
            print("", true);
        }

        public void updateHeight(MyTreeNode node){
            if(node == null) {
                node.setHeight(0);
            }
            else if (node.getRight() != null && node.getLeft() != null){
                node.setHeight(Math.max(node.getRight().getHeight(), node.getLeft().getHeight()) + 1);
                System.out.println(node.getRight().getHeight());
            }

        }

        public void updateBalance(MyTreeNode node){
            if(node == null) {
                node.setBalance(0);
            }
            else if (node.getRight() != null && node.getLeft() != null){
                node.setBalance(node.getLeft().getHeight() - node.getRight().getHeight());
            }

        }

        private void print(String prefix, boolean isTail) {
            System.out.println(prefix + (isTail ? "└── " : "├── ") + data + " (h: " + height + " b: " + balance + ")");
            if (right != null) {
                right.print(prefix + (isTail ? "    " : "│   "), false);
            } else {
                System.out.println(prefix + (isTail ? "    " : "│   ") + (isTail ? "└── " : "├── "));
            }

            if (left != null) {
                left.print(prefix + (isTail ? "    " : "│   "), false);
            } else {
                System.out.println(prefix + (isTail ? "    " : "│   ") + (isTail ? "└── " : "├── "));
            }
        }
    }
}
