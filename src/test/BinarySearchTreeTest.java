package test;

import org.junit.Test;
import main.*;
import java.util.List;

class BinarySearchTreeTest {

    @org.junit.jupiter.api.Test
    void insert1() {
        BinarySearchTree<Integer> bstree = new BinarySearchTree<>();
        int[] arr = {1,3,4,65,5,6,7,20};
        for(int i: arr)
            bstree.insert(i);

        bstree.preorderPrint();
        bstree.inorderPrint();
        bstree.BFS();

    }

    @org.junit.jupiter.api.Test
    void delete() {
        BinarySearchTree<Integer> bstree = new BinarySearchTree<>();
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

        printPass("delete() test passed.");
    }

    @org.junit.jupiter.api.Test
    void search() {
        BinarySearchTree<Integer> bstree = new BinarySearchTree();
        int[] arr = {1,3,4,65,5,6,7,20};
        for(int i: arr)
            bstree.insert(i);
        bstree.preorderPrint();
        bstree.inorderPrint();

        assert bstree.search(3);
        assert !bstree.search(0);
        printPass("search() test passed.");
    }


    @Test
    void randomValueTest(){

    }

    void printPass(String str){
        System.out.println(BinarySearchTree.class + " " + str);
    }
}