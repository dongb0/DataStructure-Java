package test;

import org.junit.Test;
import main.*;
import java.util.List;

class BinarySearchTreeTest {

    @org.junit.jupiter.api.Test
    void insert1() {
        BinarySearchTree bstree = new BinarySearchTree();
        int[] arr = {1,3,4,65,5,6,7,20};
        for(int i: arr)
            bstree.insert(i);

        bstree.preorderPrint();
        bstree.inorderPrint();
        bstree.BFS();

    }

    @org.junit.jupiter.api.Test
    void delete() {
        BinarySearchTree bstree = new BinarySearchTree();
        int[] arr = {1,3,4,65,5,6,7,20};
        for(int i: arr)
            bstree.insert(i);
        bstree.preorderPrint();
        bstree.inorderPrint();

        System.out.println("----------after delete----------");
        bstree.delete(65);
        bstree.preorderPrint();
        bstree.inorderPrint();

        //TODO
        //assert getInorder sequence == expectation
    }

    @org.junit.jupiter.api.Test
    void search() {
        BinarySearchTree bstree = new BinarySearchTree();
        int[] arr = {1,3,4,65,5,6,7,20};
        for(int i: arr)
            bstree.insert(i);
        bstree.preorderPrint();
        bstree.inorderPrint();

        assert bstree.search(3);
        assert !bstree.search(0);

        Node target = new Node(3);
        assert bstree.search(target).getValue() == 3;
        assert bstree.search(new Node(80)) == null;
    }


    @Test
    void randomValueTest(){

    }
}