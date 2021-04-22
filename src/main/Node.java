package main;

import java.util.ArrayList;
import java.util.List;

public class Node<T extends Comparable<T>> implements Comparable<T>{
    protected Node<T> left, right;
    protected T value;

    public Node(){}
    public Node(T value){ this.value = value;}
    public Node(T value, Node<T> left, Node<T> right) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public static List<Node> createNodes(int[] arr){
        List<Node> list = new ArrayList<>();
        for(int n: arr)
            list.add(new Node(n));
        return list;
    }

    @Override
    public int compareTo(T o) {
        return this.value.compareTo(o);
    }
}


//public class Node{
//    Node left, right;
//    int value;
//
//    public Node getLeft() {
//        return left;
//    }
//
//    public void setLeft(Node left) {
//        this.left = left;
//    }
//
//    public Node getRight() {
//        return right;
//    }
//
//    public void setRight(Node right) {
//        this.right = right;
//    }
//
//    public int getValue() {
//        return value;
//    }
//
//    public void setValue(int value) {
//        this.value = value;
//    }
//
//    public Node(){}
//    public Node(int value) {
//        this.value = value;
//    }
//    public Node(int value, Node left, Node right){
//        this.value = value;
//        this.left = left;
//        this.right = right;
//    }
//
//    @Override
//    public String toString() {
//        return "Node{" +
//                "left=" + left +
//                ", right=" + right +
//                ", value=" + value +
//                '}';
//    }
//}
