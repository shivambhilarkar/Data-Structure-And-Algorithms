package Trees.BinaryTrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    Node root;

    BinaryTree() {
        this.root = null;
    }

    BinaryTree(int[] input) {
        this.root = createBinaryTree(input, 0);
    }

    private Node createBinaryTree(int[] input, int index) {

        Node node = new Node(input[index]);
        final int left = index * 2 + 1;
        final int right = index * 2 + 2;

        if (left < input.length) {
            node.left = createBinaryTree(input, left);
        }
        if (right < input.length) {
            node.right = createBinaryTree(input, right);
        }
        return node;
    }

    /**
     * create Binary Search Tree using array.
     */
    public void createBinarySearchTree(int[] input) {
        this.root = createBST(input, 0, input.length - 1);
    }

    private Node createBST(int[] input, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        Node node = new Node(input[mid]);
        node.left = createBST(input, start, mid - 1);
        node.right = createBST(input, mid + 1, end);
        return node;

    }

    /**
     * Level Order Traversal using BFS.
     */
    public void printBinaryTree() throws Exception {
        if (this.root == null) {
            throw new Exception("[ Empty Tree!!!. ]");
        }

        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.println(queue);
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }


    public void printPreOrder() {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        System.out.println("[ Preorder : " + result + "]");
    }

    private void preorder(Node node, List<Integer> result) {
        if (node == null) return;
        result.add(node.value);
        preorder(node.left, result);
        preorder(node.right, result);
    }


    public void printInOrder() {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        System.out.println("[ Inorder :  " + result + " ]");
    }

    private void inorder(Node node, List<Integer> result) {
        if (node == null) return;

        inorder(node.left, result);
        result.add(node.value);
        inorder(node.right, result);
    }

    public void printPostOrder() {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        System.out.println("[ Postorder : " + result + "]");
    }

    private void postorder(Node node, List<Integer> result) {
        if (node == null) return;
        postorder(node.left, result);
        postorder(node.right, result);
        result.add(node.value);
    }
}
