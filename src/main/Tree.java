package main;

import java.util.List;

public interface Tree {

    void insert(int value);
    void delete(int value);
    void preorderPrint();
    void inorderPrint();
    void BFS();
    void draw();
    void clear();
    List<Node> getPreorder();
    List<Node> getInorder();
}
