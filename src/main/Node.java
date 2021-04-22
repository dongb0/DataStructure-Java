package main;

import java.util.ArrayList;
import java.util.List;

public class Node<T extends Comparable<T>> implements Comparable<T>{
    protected Node<T> left, right;
    protected T value;
    protected int height;

    public Node(){}
    public Node(T value){ this.value = value;}
    public Node(T value, Node<T> left, Node<T> right) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public Node(T value, int height) {
        this.value = value;
        this.height = height;
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

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", height=" + height +
                '}';
    }
}
