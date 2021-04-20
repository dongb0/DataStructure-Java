package main;

import java.util.List;

public interface Tree<T extends Comparable<T>> {

    void insert(T value);
    void delete(T value);
    void preorderPrint();
    void inorderPrint();
    void BFS();
    void draw();
    void clear();
    List<Node<T>> getPreorder();
    List<Node<T>> getInorder();
}
