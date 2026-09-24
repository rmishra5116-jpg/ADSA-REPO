import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BSTTraversal {

    static Scanner sc = new Scanner(System.in);

    // Insert Node (Recursive input)
    public static Node insertNode() {
        int data = sc.nextInt();

        if (data == -1) {
            return null;
        }

        Node node = new Node(data);
        node.left = insertNode();
        node.right = insertNode();

        return node;
    }

    // Preorder Traversal
    public static void preorder(Node node) {
        if (node == null) return;

        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    // Inorder Traversal
    public static void inorder(Node node) {
        if (node == null) return;

        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    // Postorder Traversal
    public static void postorder(Node node) {
        if (node == null) return;

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        System.out.println("Enter data (-1 for NULL node):");

        Node root = insertNode();

        System.out.println("\nPreorder Traversal:");
        preorder(root);

        System.out.println("\nInorder Traversal:");
        inorder(root);

        System.out.println("\nPostorder Traversal:");
        postorder(root);
    }
}