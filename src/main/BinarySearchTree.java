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

        if(cur == null || cur.value != value)
            return ;
        if(cur.left == null && cur.right == null){
            deleteNode(pre, cur, null);
            return ;
        }
        if(cur.left == null){
            deleteNode(pre, cur, cur.right);
        }
        else if(cur.right == null)
            deleteNode(pre, cur, cur.left);
        else{
            Node tmp = cur.left;
            while(tmp.right != null){
                tmp = tmp.right;
            }
            tmp.right = cur.right;
            deleteNode(pre, cur, cur.left);
        }
    }

    void deleteNode(Node pre, Node cur, Node newPoint){
        if(cur == root)
            root = (cur.left != null ? cur.left: cur.right);
        else
            if(cur == pre.left)
                pre.left = newPoint;
            else
                pre.right = newPoint;
    }

    protected void copy_delete(T value){

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
