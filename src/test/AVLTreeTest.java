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
        avlTree.preorderPrint();
        System.out.println();
    }
    boolean checkValueEquals(List<Node> ans, List<Node> list){
        if(ans.size() != list.size())
            return false;
        for(int i = 0, sz = ans.size(); i < sz; i++)
            if(ans.get(i).getValue() != list.get(i).getValue())
                return false;
        return true;
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
        System.out.println("\npreorder list:" + preList);
        System.out.println("inorder list:" + inList);
        assert checkValueEquals(preAns, preList);
        assert checkValueEquals(inAns, inList);
    }

    @Test
    void insert_RR() {
        AVLTree avlTree = new AVLTree();
        insert_print(avlTree, 10);
        insert_print(avlTree, 15);
        insert_print(avlTree, 20);
        insert_print(avlTree, 25);
        insert_print(avlTree, 30);

        List<Node> preAns = Node.createNodes(new int[]{15, 10, 25, 20, 30}), inAns = Node.createNodes(new int[]{10, 15, 20, 25, 30});
        List<Node> preList = avlTree.getPreorder();
        List<Node> inList = avlTree.getInorder();
        System.out.println("\npreorder list:" + preList);
        System.out.println("inorder list:" + inList);
        assert checkValueEquals(preAns, preList);
        assert checkValueEquals(inAns, inList);
    }


    @Test
    void insert_LR(){
        AVLTree avlTree = new AVLTree();
        insert_print(avlTree, 20);
        insert_print(avlTree, 10);
        insert_print(avlTree, 15);
        insert_print(avlTree, 18);
        insert_print(avlTree, 19);

        List<Node> preAns = Node.createNodes(new int[]{15,10,19,18,20}), inAns = Node.createNodes(new int[]{10,15,18,19,20});
        List<Node> preList = avlTree.getPreorder();
        List<Node> inList = avlTree.getInorder();
        System.out.println("\npreorder list:" + preList);
        System.out.println("inorder list:" + inList);
        assert checkValueEquals(preAns, preList);
        assert checkValueEquals(inAns, inList);
    }

    @Test
    void insert_RL(){
        AVLTree avlTree = new AVLTree();
        insert_print(avlTree, 5);
        insert_print(avlTree, 15);
        insert_print(avlTree, 10);
        insert_print(avlTree, 20);
        insert_print(avlTree, 18);

        List<Node> preAns = Node.createNodes(new int[]{10, 5, 18, 15, 20}), inAns = Node.createNodes(new int[]{5, 10, 15, 18, 20});
        List<Node> preList = avlTree.getPreorder();
        List<Node> inList = avlTree.getInorder();
        System.out.println("\npreorder list:" + preList);
        System.out.println("inorder list:" + inList);
        assert checkValueEquals(preAns, preList);
        assert checkValueEquals(inAns, inList);
    }

    @Test
    void delete() {

    }


}