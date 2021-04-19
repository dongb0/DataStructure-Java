package test;

import main.AVLTree;
import main.Node;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class AVLTreeTest {

    @Test
    void insert() {
        AVLTree avlTree = new AVLTree();
        int val = 10;
        System.out.println("Insert " + val);
        avlTree.insert(val);
        System.out.print("preOrder: ");
        avlTree.preorder(avlTree.getRoot());
        System.out.println();

        val = 5;
        System.out.println("Insert " + val);
        avlTree.insert(val);
        System.out.print("preOrder: ");
        avlTree.preorder(avlTree.getRoot());
        System.out.println();

        val = 2;
        System.out.println("Insert " + val);
        avlTree.insert(val);
        System.out.print("preOrder: ");
        avlTree.preorder(avlTree.getRoot());
        System.out.println();

        val = 0;
        System.out.println("Insert " + val);
        avlTree.insert(val);
        System.out.print("preOrder: ");
        avlTree.preorder(avlTree.getRoot());
        System.out.println();

        val = -1;
        System.out.println("Insert " + val);
        avlTree.insert(val);
        System.out.print("preOrder: ");
        avlTree.preorder(avlTree.getRoot());
        System.out.println();

    }

    @Test
    void delete() {
    }

    @Test
    void getHeight(){
//        AVLTree tree = new AVLTree();
//        Class<AVLTree> c = AVLTree.class;
//        try {
//            Method method = c.getDeclaredMethod("getHeight", Node.class);
//            method.setAccessible(true);
////            method.invoke(getHeight(), tree.getRoot());
//
//            method.setAccessible(false);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
    }
}