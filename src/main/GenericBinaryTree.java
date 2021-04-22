package main;

import java.util.*;

public class GenericBinaryTree<T extends Comparable<T>> implements Tree<T>{
    Node<T> root;
    int size;

    @Override
    public void insert(T value) {
    }

    @Override
    public void delete(T value) {
    }

    @Override
    public void preorderPrint() {
        System.out.print("preorder:[ ");
        for(Node<T> n: getPreorder())
            System.out.print(n.value + " ");
        System.out.println("]");
    }

    @Override
    public void inorderPrint() {
        System.out.print("inorder:[ ");
        for(Node n: getInorder())
            System.out.print(n.value + " ");
        System.out.println("]");
    }

    @Override
    public void BFS() {
        System.out.println("BFS:");
        if(root == null)
            return ;
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            for(int i = queue.size(); i > 0; i--){
                Node<T> cur = queue.poll();
                assert cur != null;
                System.out.print(cur.value + " ");
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }
            System.out.println();
        }
    }

    @Override
    public void draw() {

    }

    @Override
    public void clear() {
        //rubbish collector does its job?
        root = null;
    }

    @Override
    public List<Node<T>> getPreorder() {
        List<Node<T>> list = new ArrayList<>();
        Stack<Node<T>> stack = new Stack<>();
        Node<T> cur = root;
        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                list.add(new Node<T>(cur.value, cur.height));
                stack.add(cur.right);
                cur = cur.left;
            }
            else{
                cur = stack.pop();
            }
        }
        return list;
    }

    @Override
    public List<Node<T>> getInorder() {
        List<Node<T>> list = new ArrayList<>();
        Stack<Node<T>> stack = new Stack<>();
        Node<T> cur = root;
        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                stack.add(cur);
                cur = cur.left;
            }
            else{
                cur = stack.pop();
                list.add(new Node<>(cur.value, cur.height));
                cur = cur.right;
            }
        }
        return list;
    }

}
