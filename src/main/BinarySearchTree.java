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
        if(value.compareTo(pre.value) > 0)
            pre.left = newNode;
        else
            pre.right = newNode;
    }

    @Override
    public void delete(T value) {
        Node<T> cur = root, pre = root;
        while(cur != null && cur.value != value){
            pre = cur;
            if(value.compareTo(cur.value) < 0)
                cur = cur.left;
            else if (value.compareTo(cur.value) > 0)
                cur = cur.right;
        }
        assert cur != null;
        Node tmp = cur.left;
        while(tmp.right != null){
            tmp = tmp.right;
        }
        tmp.right = cur.right;
        if(cur == pre.left)
            pre.left = cur.left;
        else
            pre.right = cur.left;
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

//    public Node<T> search(Node<T> target){
//        if(root == null || target == null)
//            return null;
//        Node<T> cur = root;
//        while(cur != null){
//            if(target.compareTo(cur.value) < 0)
//                cur = cur.left;
//            else if(target.compareTo(cur.value) > 0)
//                cur = cur.right;
//            else
//                return cur;
//        }
//        return null;
//    }
}
