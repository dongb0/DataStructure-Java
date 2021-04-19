package main;

import java.util.*;

public class GenericBinaryTree implements Tree{
    Node root;

    @Override
    public void insert(int value) {
    }

    @Override
    public void delete(int value) {
    }

    @Override
    public void preorderPrint() {
        System.out.print("preorder:[ ");
        for(Node n: getPreorder())
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
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            for(int i = queue.size(); i > 0; i--){
                Node cur = queue.poll();
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
    public List<Node> getPreorder() {
        List<Node> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                list.add(new Node(cur.value));
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
    public List<Node> getInorder() {
        List<Node> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                stack.add(cur);
                cur = cur.left;
            }
            else{
                cur = stack.pop();
                list.add(new Node(cur.value));
                cur = cur.right;
            }
        }
        return list;
    }

}
