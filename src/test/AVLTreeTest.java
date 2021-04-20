package test;

import main.AVLTree;
import main.Node;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AVLTreeTest {

    void insert_print(AVLTree avlTree, int val){
        System.out.println("Insert " + val);
        avlTree.insert(val);
        System.out.print("preOrder: ");
        avlTree.preorder(avlTree.getRoot());
        System.out.println();
    }


    @Test
    void insert_LL() {
        AVLTree avlTree = new AVLTree();
        insert_print(avlTree, 10);
        insert_print(avlTree, 5);
        insert_print(avlTree, 2);
        insert_print(avlTree, 0);
        insert_print(avlTree, -1);

        List<Node> preAns = Node.createNodes(new int[]{5,0,-1,2,10}), inAns = Node.createNodes(new int[]{-1,0,2,5,10});
        List<Node> preList = avlTree.getPreorder();
        List<Node> inList = avlTree.getInorder();
        System.out.println(preAns.get(0) == preList.get(0));
        assert preAns.equals(preList);
        assert inList.equals(inAns);
    }

    @Test
    void insert_LR(){
        AVLTree avlTree = new AVLTree();
        insert_print(avlTree, 20);
        insert_print(avlTree, 10);
        insert_print(avlTree, 15);
        insert_print(avlTree, 18);
        insert_print(avlTree, 19);

        List<Node> preList = avlTree.getPreorder();
        List<Node> inList = avlTree.getInorder();
    }

    @Test
    void delete() {

    }


}