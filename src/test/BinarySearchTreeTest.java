package test;

import org.junit.Test;
import main.*;
import java.util.List;

class BinarySearchTreeTest {

    @org.junit.jupiter.api.Test
    void insert1() {
        BinarySearchTree<Integer> bstree = new BinarySearchTree<>();
        int[] arr = {1,3,4,65,5,6,7,20,-10,-5,-9,-14};
        for(int i: arr)
            bstree.insert(i);

        bstree.preorderPrint();
        bstree.inorderPrint();
        bstree.BFS();

        List<Node<Integer>> inList = bstree.getInorder();
        assert TestUtils.isAscend(inList);
        printPass("insert1() test passed.");
    }

    @org.junit.jupiter.api.Test
    void delete() {
        BinarySearchTree<Integer> bstree = new BinarySearchTree<>();
        int[] arr = {1,3,4,65,5,6,7,20,-10,-5,-9,-14};
        for(int i: arr)
            bstree.insert(i);
        bstree.preorderPrint();
        bstree.inorderPrint();

        int deleteValue = -10;
        System.out.printf("----------after delete %d----------\n", deleteValue);
        bstree.delete(deleteValue);
        bstree.preorderPrint();
        bstree.inorderPrint();
        List<Node<Integer>> inList = bstree.getInorder();
        assert  TestUtils.isAscend(inList);

        deleteValue = 1;
        System.out.printf("----------after delete %d----------\n", deleteValue);
        bstree.delete(deleteValue);
        bstree.preorderPrint();
        bstree.inorderPrint();


        System.out.printf("----------after delete 3, -9, 5----------\n");
        bstree.delete(3);
        bstree.delete(-9);
        bstree.delete(5);
        //TODO
        //assert getInorder sequence == expectation
        bstree.preorderPrint();
        bstree.inorderPrint();
        inList = bstree.getInorder();
        assert  TestUtils.isAscend(inList);
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

    //TODO: add random test

    @Test
    void randomValueTest(){

    }

    void printPass(String str){
        System.out.println(BinarySearchTree.class + " " + str);
    }
}