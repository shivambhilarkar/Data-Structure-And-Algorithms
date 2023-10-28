package Trees.BinaryTrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Q1_Introduction_to_Binary_Trees {


    public static void main(String[] args) throws Exception {


        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        BinaryTree tree = new BinaryTree(input);

        tree.printBinaryTree();
        System.out.println("=======================");
        tree.printPreOrder();
        tree.printInOrder();
        tree.printPostOrder();


        System.out.println("=====================");
        BinaryTree bst = new BinaryTree();
        bst.createBinarySearchTree(input);
        bst.printBinaryTree();
        bst.printPreOrder();
        bst.printInOrder();
        bst.printPostOrder();


    }

}
