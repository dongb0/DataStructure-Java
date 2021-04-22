package main;

import java.util.Stack;

public class AVLTree<T extends Comparable<T>> extends GenericBinaryTree<T> {
//    Node<T> root;

    public AVLTree(){

    }

    @Override
    public void insert(T value) {
        Node<T> newNode = new Node(value);
        newNode.height = 1;
        if(root == null){
            root = newNode;
            return;
        }
        Node<T> cur = root, pre = null;
        Stack<Node> insertPath = new Stack<>();
        while(cur != null){
            pre = cur;
            insertPath.add(cur);
            cur.height++;   //update height
            if(value.compareTo(cur.value) < 0)
                cur = cur.left;
            else
                cur = cur.right;
        }
        if(value.compareTo(pre.value) < 0)
            pre.left = newNode;
        else
            pre.right = newNode;

        Node imbalancedNode = null;
        while(!insertPath.isEmpty()){
            Node node = insertPath.pop();
            if(Math.abs(getBalance(node)) > 1){
                imbalancedNode = node;
                break;
            }
        }
        Node rotateRoot = null;
        if(imbalancedNode != null && getBalance(imbalancedNode.left) < 0) // LR
            imbalancedNode.left = rotateRight(imbalancedNode.left);
        else if(imbalancedNode != null && getBalance(imbalancedNode.right) > 0) // RL
            imbalancedNode.right = rotateLeft(imbalancedNode.right);

        if(imbalancedNode != null && getBalance(imbalancedNode.left) > 0) // LL
            rotateRoot = rotateLeft(imbalancedNode);
        else if(imbalancedNode != null && getBalance(imbalancedNode.right) < 0) // RR
            rotateRoot = rotateRight(imbalancedNode);

        if(imbalancedNode != null) {
            if(!insertPath.isEmpty()){
                Node tmpPre = insertPath.pop();
                if(imbalancedNode == tmpPre.left)
                    tmpPre.left = rotateRoot;
                else tmpPre.right = rotateRoot;
                tmpPre.height = 1 + Math.max(getHeight(tmpPre.left), getHeight(tmpPre.right));
                while(!insertPath.isEmpty()){
                    tmpPre = insertPath.pop();
                    tmpPre.height = 1 + Math.max(getHeight(tmpPre.left), getHeight(tmpPre.right));
                }
            }
            else{
                root = rotateRoot;
            }
        }
    }

//    @Override
    public void delete(int value) {

    }


    private Node rotateLeft(Node cur){
        Node child = cur.left;
        cur.left = child.right;
        child.right = cur;
        cur.height = 1 + Math.max(getHeight(cur.left), getHeight(cur.right));
        child.height = 1 + Math.max(getHeight(child.left), getHeight(child.right));
        return child;
    }

    private Node rotateRight(Node cur){
        Node child = cur.right;
        cur.right = child.left;
        child.left = cur;
        cur.height = 1 + Math.max(getHeight(cur.left), getHeight(cur.right));
        child.height = 1 + Math.max(getHeight(child.left), getHeight(child.right));
        return child;
    }

    private int getHeight(Node cur){
        return cur != null ? cur.height: 0;
    }

    private int getBalance(Node cur){
        if(cur == null)
            return 0;
        return getHeight(cur.left) - getHeight(cur.right);
    }

    public Node getRoot() {
        return root;
    }

    public void preorder(Node cur){
        if(cur == null) return;
        System.out.print(cur + " ");
        preorder(cur.left);
        preorder(cur.right);
    }

}


//class AVLNode<T extends Comparable<T>> extends Node<T> {
//    public AVLNode() {
//    }
//
//    @Override
//    public String toString() {
//        return "AVLNode{" +
//                "value=" + value +
//                ", height=" + height +
//                '}';
//    }
//}

