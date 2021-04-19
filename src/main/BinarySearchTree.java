package main;

public class BinarySearchTree extends GenericBinaryTree {

    @Override
    public void insert(int value) {
        Node newNode = new Node(value);
        if(root == null){
            root = newNode;
            return ;
        }
        Node cur = root, pre = null;
        while(cur != null){
            pre = cur;
            if(value < cur.value)
                cur = cur.left;
            else /*if(value > cur.value)*/
                cur = cur.right;
        }
        if(value < pre.value)
            pre.left = newNode;
        else
            pre.right = newNode;
    }

    @Override
    public void delete(int value) {
        Node cur = root, pre = root;
        while(cur != null && cur.value != value){
            pre = cur;
            if(value < cur.value)
                cur = cur.left;
            else if (value > cur.value)
                cur = cur.right;
        }
        Node tmp = cur;
        while(tmp.right != null){
            tmp = tmp.right;
        }
        tmp.right = cur.right;
        if(cur == pre.left)
            pre.left = cur.left;
        else
            pre.right = cur.left;
    }

    public boolean search(int target){
        if(root == null)
            return false;
        Node cur = root;
        while(cur != null){
            if(target < cur.value)
                cur = cur.left;
            else if(target > cur.value)
                cur = cur.right;
            else
                return true;
        }
        return false;
    }

    public Node search(Node target){
        if(root == null || target == null)
            return null;
        Node cur = root;
        while(cur != null){
            if(target.value < cur.value)
                cur = cur.left;
            else if(target.value > cur.value)
                cur = cur.right;
            else
                return cur;
        }
        return null;
    }
}
