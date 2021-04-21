package main;

public class BinarySearchTree<T extends Comparable<T>> extends GenericBinaryTree<T> {

    @Override
    public void insert(T value) {
        Node<T> newNode = new Node<>(value);
        if(root == null){
            root = newNode;
            return ;
        }
        Node<T> cur = root, pre = null;
        while(cur != null){
            pre = cur;
            if(value.compareTo(cur.value) < 0)
                cur = cur.left;
            else
                cur = cur.right;
        }
        if(value.compareTo(pre.value) < 0)
            pre.left = newNode;
        else
            pre.right = newNode;
    }

    @Override
    public void delete(T value) {
        merge_delete(value);
    }

    void setNodeSubtree(Node pre, boolean isLeft, Node newPoint){
        if(isLeft) pre.left = newPoint;
        else pre.right = newPoint;
    }

    protected void merge_delete(T value){
        if(root == null)
            return ;
        Node<T> cur = root, pre = new Node<>(value, root, null);
        while(cur != null && cur.value != value){
            pre = cur;
            if(value.compareTo(cur.value) < 0)
                cur = cur.left;
            else if (value.compareTo(cur.value) > 0)
                cur = cur.right;
            else break;
        }
        boolean isLeft = (cur == pre.left);
        if(cur == null || cur.value != value)
            return ;
        if(cur.left == null && cur.right == null){
            setNodeSubtree(pre, isLeft, null);
            return ;
        }

        if(cur.left == null)
            setNodeSubtree(pre, isLeft, cur.right);
//            ;
        else if(cur.right == null)
            setNodeSubtree(pre, isLeft, cur.left);
//            ;
        else{
            Node tmp = cur.left;
            while(tmp.right != null){
                tmp = tmp.right;
            }
            tmp.right = cur.right;
        }

        if(cur == root)
            root = cur.left;
//        else if(cur == pre.left)
//            pre.left = cur.left;
//        else
//            pre.right = cur.left;
    }

    protected void copy_delete(T value){
//        Node<T> cur = root, pre = new Node<T>(value, cur, null);
//        while(cur != null && cur.value != value){
//            pre = cur;
//            if(value.compareTo(cur.value) < 0)
//                cur = cur.left;
//            else if (value.compareTo(cur.value) > 0)
//                cur = cur.right;
//        }
//        if(cur == null)
//            return ;
//        if(cur.left == null && cur.right == null)
//            pre. = null;
//        if(cur.left == null)
//            pre. = cur.right;
//        else if(cur.right == null)
//            pre. = cur.left;
//        else{
//
//        }
    }

    public boolean search(T target){
        if(root == null)
            return false;
        Node<T> cur = root;
        while(cur != null){
            if(target.compareTo(cur.value) < 0)
                cur = cur.left;
            else if(target.compareTo(cur.value) > 0)
                cur = cur.right;
            else
                return true;
        }
        return false;
    }

    public Node<T> search(Node<T> target){
        if(root == null || target == null)
            return null;
        Node<T> cur = root;
        while(cur != null){
            if(target.compareTo(cur.value) < 0)
                cur = cur.left;
            else if(target.compareTo(cur.value) > 0)
                cur = cur.right;
            else
                return cur;
        }
        return null;
    }
}
