import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BSTSearch {

    // Insert into BST (using property)
    public static Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        if (data < node.data) {
            node.left = insert(node.left, data);
        } else {
            node.right = insert(node.right, data);
        }

        return node;
    }

    // Search in BST
    public static boolean searchBST(Node node, int key) {
        if (node == null) return false;

        if (node.data == key) return true;

        if (key < node.data)
            return searchBST(node.left, key);
        else
            return searchBST(node.right, key);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node root = null;

        System.out.println("Enter number of nodes:");
        int n = sc.nextInt();

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            root = insert(root, data);
        }

        System.out.print("Enter key to search: ");
        int key = sc.nextInt();

        if (searchBST(root, key)) {
            System.out.println("Key found");
        } else {
            System.out.println("Key not found");
        }
    }
}