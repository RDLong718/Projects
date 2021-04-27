package binarytree;

// Node class stores int values and has children (left, right)
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Rashad Long 
 * This is a version of the Binary Tree containing an
 * insertion function and a traversal function. The insertion function sorts the
 * Binary Tree according to the BST rules.
 */
// First we create the Nodes
class Node {

    int value;
    Node right;
    Node left;

    //int value in the Node and null values to the right and left
    Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }
}

public class BinaryTree {

    //the root of the BinaryTree
    Node root;

    /**
     * This method inserts values into the leaves of the tree starting with the
     * left side. It is a recursive function. It sorts the values also with the
     * lessor going to the left leaf. Made this private because this is not
     * going to be known to the user. The user will call on the 'add' method.
     * The 'add' method will then call on this private insertion method.
     *
     * @param current
     * @param value
     * @return
     */
    private Node insertion(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.value) {
            current.left = insertion(current.left, value);
        } else if (value > current.value) {
            current.right = insertion(current.right, value);
        }
        return current;
    }

    /**
     * This method calls on the insertion method in order to add values to the
     * binary tree.
     *
     * @param value
     */
    public void add(int value) {
        root = insertion(root, value);
    }

    /**
     * This method places the nodes into a LinkedList in order to read in the
     * nodes and then display them in order from root to leaves (left to right).
     */
    public void traverse() {
        if (root == null) {
            return;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        //while the LinkedList has a value print the value of the node removed. 
        while (!nodes.isEmpty()) {

            Node node = nodes.remove();
            System.out.println(" " + node.value);

            //Print the left leaf first        
            if (node.left != null) {
                nodes.add(node.left);
            }
            //print the right leaft next
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        bt.add(88);
        bt.add(35);
        bt.add(10);
        bt.add(25);
        bt.add(40);
        bt.add(55);
        bt.traverse();
    }
}
