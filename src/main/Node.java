package main;

import java.util.ArrayList;
import java.util.List;

// TODO: class Node generalization
public class Node{
    Node left, right;
    int value;

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node(){}
    public Node(int value) {
        this.value = value;
    }
    public Node(int value, Node left, Node right){
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public static List<Node> createNodes(int[] arr){
        List<Node> list = new ArrayList<>();
        for(int n: arr)
            list.add(new Node(n));
        return list;
    }

    @Override
    public String toString() {
        return "Node{" +
                "left=" + left +
                ", right=" + right +
                ", value=" + value +
                '}';
    }
}
