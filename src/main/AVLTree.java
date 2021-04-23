package main;

import java.util.Stack;

public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T> {

    public AVLTree(){

    }

    @Override
    public void insert(T value) {
        size++;
        Node<T> newNode = new Node(value);  // if out of memory, throws exceptions here
        newNode.height = 1;
        if(root == null){
            root = newNode;
            return;
        }
        Node<T> cur = root, pre = null;
        Stack<Node<T>> insertPath = new Stack<>();
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

        // update nodes' height along path
        Stack<Node> path = new Stack<>();
        path.addAll(insertPath);
        if(!insertPath.isEmpty()){
            Node tmpPre = path.pop();
            tmpPre.height = 1 + Math.max(getHeight(tmpPre.left), getHeight(tmpPre.right));
            while(!path.isEmpty()){
                tmpPre = path.pop();
                tmpPre.height = 1 + Math.max(getHeight(tmpPre.left), getHeight(tmpPre.right));
            }
        }

        Node<T> imbalancedNode = null;
        while(!insertPath.isEmpty()){
            Node<T> node = insertPath.pop();
            if(Math.abs(getBalance(node)) > 1){
                imbalancedNode = node;
                break;
            }
        }

        if(imbalancedNode == null)
            return ;
        Node<T> rotateRoot = rebalance(imbalancedNode);
        if(!insertPath.isEmpty()){
            Node tmpPre = insertPath.pop();
            if(imbalancedNode == tmpPre.left)
                tmpPre.left = rotateRoot;
            else
                tmpPre.right = rotateRoot;
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

    private Node<T> rebalance(Node<T> imbalancedNode){
        if(imbalancedNode == null)
            return null;
        Node<T> rotateRoot = null;
        int factor = getBalance(imbalancedNode);
        if(factor > 1){ // LL or LR
            if(getBalance(imbalancedNode.left) > 0) //LL
                rotateRoot = rotateRight(imbalancedNode);
            else{ //LR, == 0 for delete
                imbalancedNode.left = rotateLeft(imbalancedNode.left);
                rotateRoot = rotateRight(imbalancedNode);
            }
        }
        else{ // factor < -1, RR or RL
            if(getBalance(imbalancedNode.right) < 0) //RR
                rotateRoot = rotateLeft(imbalancedNode);
            else{ //RL
                imbalancedNode.right = rotateRight(imbalancedNode.right);
                rotateRoot = rotateLeft(imbalancedNode);
            }
        }
        return rotateRoot;
    }

    private void loop_insert(T value){

    }

    private void recursive_insert(T value){

    }

    @Override
    public void delete(T value) {
        if(root == null)
            return ;
        Stack<Node<T>> path = new Stack<>();
        Node<T> cur = root, pre = null;
        while(cur != null && cur.value.compareTo(value) != 0){
            pre = cur;
            path.add(cur);
            if(value.compareTo(cur.value) < 0)
                cur = cur.left;
            else
                cur = cur.right;
        }
        if(cur == null)
            return ;
        if(cur.left == null)
            deleteNode(pre, cur, cur.right);
        else if(cur.right == null)
            deleteNode(pre, cur, cur.left);
        else{
            Node<T> successor = cur.right, last = cur;
            while(successor.left != null){
                last = successor;
                successor = successor.left;
            }
            cur.value = successor.value;
            deleteNode(last, successor, successor.right);
            path.add(cur); // cur.subtree's height may change and needed rebalance
        }
        //reBalance
        Node<T> rotateRoot = null;
        while(!path.isEmpty()){
            cur = path.pop();
            if(Math.abs(getBalance(cur)) > 1){
                rotateRoot = rebalance(cur);
                if(!path.isEmpty()){
                    if(cur == path.peek().left)
                        path.peek().left = rotateRoot;
                    else
                        path.peek().right = rotateRoot;
                }
                else{
                    root = rotateRoot;
                }
            }
        }
    }


    private Node<T> rotateRight(Node<T> cur){
        assert cur.left != null;
        Node<T> child = cur.left;
        cur.left = child.right;
        child.right = cur;
        cur.height = 1 + Math.max(getHeight(cur.left), getHeight(cur.right));
        child.height = 1 + Math.max(getHeight(child.left), getHeight(child.right));
        return child;
    }

    private Node<T> rotateLeft(Node<T> cur){
        assert cur.right != null;
        Node<T> child = cur.right;
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

}


