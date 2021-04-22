package main;

import java.util.Stack;

public class AVLTree /*extends GenericBinaryTree*/ {
    AVLNode root;

    public AVLTree(){

    }

//    @Override
    public void insert(int value) {
        AVLNode newNode = new AVLNode(value);
        newNode.height = 1;
        if(root == null){
            root = newNode;
            return;
        }
        AVLNode cur = root, pre = null;
        Stack<AVLNode> insertPath = new Stack<>();
        while(cur != null){
            pre = cur;
            insertPath.add(cur);
            cur.height++;   //update height
            if(value < cur.value)
                cur = cur.left;
            else
                cur = cur.right;
        }
        if(value < pre.value)
            pre.left = newNode;
        else
            pre.right = newNode;

        AVLNode imbalancedNode = null;
        while(!insertPath.isEmpty()){
            AVLNode node = insertPath.pop();
            if(Math.abs(getBalance(node)) > 1){
                imbalancedNode = node;
                break;
            }
        }
        AVLNode rotateRoot = null;
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
                AVLNode tmpPre = insertPath.pop(), tmpCur = rotateRoot;
                if(imbalancedNode == tmpPre.left)
                    tmpPre.left = rotateRoot;
                else tmpPre.right = rotateRoot;
                tmpPre.height = 1 + Math.max(getHeight(tmpPre.left), getHeight(tmpPre.right));
                while(!insertPath.isEmpty()){
//                    tmpCur = tmpPre;
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


    private AVLNode rotateLeft(AVLNode cur){
        AVLNode child = cur.left, grandson = cur.left.left;
        cur.left = child.right;
        child.right = cur;
        cur.height = 1 + Math.max(getHeight(cur.left), getHeight(cur.right));
        child.height = 1 + Math.max(getHeight(child.left), getHeight(child.right));
        return child;
    }

    private AVLNode rotateRight(AVLNode cur){
        AVLNode child = cur.right;
        cur.right = child.left;
        child.left = cur;
        cur.height = 1 + Math.max(getHeight(cur.left), getHeight(cur.right));
        child.height = 1 + Math.max(getHeight(child.left), getHeight(child.right));
        return child;
    }

    private int getHeight(AVLNode cur){
        return cur != null ? cur.height: 0;
    }

    private int getBalance(AVLNode cur){
        if(cur == null)
            return 0;
        return getHeight(cur.left) - getHeight(cur.right);
    }

    public AVLNode getRoot() {
        return root;
    }

    public void preorder(AVLNode cur){
        if(cur == null) return;
        System.out.print(cur + " ");
        preorder(cur.left);
        preorder(cur.right);
    }

}


class AVLNode {
    protected int value, height;
    protected AVLNode left, right;

    public AVLNode() {
    }

    public AVLNode(int value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "AVLNode{" +
                "value=" + value +
                ", height=" + height +
                '}';
    }
}

