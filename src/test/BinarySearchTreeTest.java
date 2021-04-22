package test;

import main.*;
import org.junit.jupiter.api.Test;

import java.util.*;

class BinarySearchTreeTest {

    void printPass(String str){
        System.out.println(BinarySearchTree.class + " " + str);
    }
    void checkBinaryTreeRule(GenericBinaryTree<Integer> tree, int expectedSize){
        List<Node<Integer>> inList = tree.getInorder();
        assert inList.size() == expectedSize: String.format("expected len=%d, got %d", expectedSize, inList.size());
        assert TestUtils.isAscend(inList);
    }

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
        int len = arr.length;
        for(int i: arr)
            bstree.insert(i);
        bstree.preorderPrint();
        bstree.inorderPrint();

        int deleteValue = -10;
        System.out.printf("----------after delete %d----------\n", deleteValue);
        bstree.delete(deleteValue);
        bstree.preorderPrint();
        bstree.inorderPrint();
        len--;
        checkBinaryTreeRule(bstree, len);

        deleteValue = 1;
        System.out.printf("----------after delete %d----------\n", deleteValue);
        bstree.delete(deleteValue);
        bstree.preorderPrint();
        bstree.inorderPrint();
        len--;
        checkBinaryTreeRule(bstree, len);

        System.out.printf("----------after delete 3, -9, 5----------\n");
        bstree.delete(3);
        bstree.delete(-9);
        bstree.delete(5);

        //delete non-existing value
        bstree.delete(5);
        bstree.delete(30);

        //TODO: assert getInorder sequence == expectation
        bstree.preorderPrint();
        bstree.inorderPrint();
        len -= 3;
        checkBinaryTreeRule(bstree, len);
        printPass("delete() test passed.");
    }

    @org.junit.jupiter.api.Test
    void delete_right(){
        BinarySearchTree<Integer> bstree = new BinarySearchTree<>();
        int[] arr = {1,3,5,7,9};
        int len = arr.length;
        for(int i: arr)
            bstree.insert(i);
        bstree.preorderPrint();
        bstree.inorderPrint();

        int deleteValue = 1;
        System.out.printf("----------after delete %d----------\n", deleteValue);
        bstree.delete(deleteValue);
        bstree.preorderPrint();
        bstree.inorderPrint();
        List<Node<Integer>> inList = bstree.getInorder();
        len--;
        checkBinaryTreeRule(bstree, len);

        deleteValue = 3;
        System.out.printf("----------after delete %d----------\n", deleteValue);
        bstree.delete(deleteValue);
        bstree.preorderPrint();
        bstree.inorderPrint();
        inList = bstree.getInorder();
        len--;
        checkBinaryTreeRule(bstree, len);

        bstree.delete(5);
        bstree.delete(7);
        bstree.delete(9);
        System.out.println("----------after delete 5, 7, 9----------");
        bstree.preorderPrint();
        bstree.inorderPrint();
        assert bstree.getInorder().isEmpty();
        printPass("delete_right() test passed.");
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
    @org.junit.jupiter.api.Test
    void randomValueTest(){
        int totalSize = 100;
        Set<Integer> set = new HashSet<>(TestUtils.getRandIntegers(totalSize));
        BinarySearchTree<Integer> bstree = new BinarySearchTree();
        for(Integer i: set)
            bstree.insert(i);

        bstree.preorderPrint();
        bstree.inorderPrint();
        checkBinaryTreeRule(bstree, totalSize);

        Iterator<Integer> iter = set.iterator();
        for(int i = 1; i <= 50 && iter.hasNext(); i++){
            bstree.delete(iter.next());
//            System.out.println("delete " + iter.next() + " bstree.size()= " + bstree.getInorder().size());
        }

        checkBinaryTreeRule(bstree, totalSize - 50);
        printPass("random_value_delete test passed.");
    }

}