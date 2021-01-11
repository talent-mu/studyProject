import java.util.Stack;

/**
 * 二叉树
 *
 * @author zmh
 * @create 2017-07-10 15:03
 **/
public class BinaryTree {
    private String test;

    class Tree {
        Node root;
    }

    class Node {
        int data;
        Node leftNode;
        Node rightNode;

        Node(int data) {
            this.data = data;
        }
    }

    private Tree insert(Tree tree, int data) {

        Node node = tree.root;
        if (null == node) {
            tree.root = new Node(data);
        }
        while (node != null) {
            if (node.data > data) {
                if (node.leftNode == null) {
                    node.leftNode = new Node(data);
                } else {
                    node = node.leftNode;
                }
            } else if (node.data < data) {
                if (node.rightNode == null) {
                    node.rightNode = new Node(data);
                } else {
                    node = node.rightNode;
                }

            } else {
                return null;
            }
        }
        return tree;
    }

    private void preorder(Node node) {
        if (null == node) {
            return;
        }
        System.out.println(node.data);
        preorder(node.leftNode);
        preorder(node.rightNode);
    }

    private void inorder(Node node) {
        if (null == node) {
            return;
        }
        inorder(node.leftNode);
        System.out.println(node.data);
        inorder(node.rightNode);
    }

    private void test() {
        int[] array = new int[]{5, 9, 7, 2, 1, 8};
        Tree tree = new Tree();
        for (int i = 0; i < array.length; i++) {
            insert(tree, array[i]);
        }
        preorder(tree.root);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        preorderByStack(tree.root);
    }

    private void preorderByStack(Node node) {
        Stack<Node> stack = new Stack<Node>();
        while (node != null || stack.size() > 0) {
            if (node != null) {
                System.out.println(node.data);
                stack.push(node);
                node = node.leftNode;
            } else {
                node = stack.pop().rightNode;
            }

        }

    }

    void inorderByStack(Node node) {
        Stack<Node> stack = new Stack<Node>();
        while (node != null || stack.size() > 0) {
            if (node != null) {
                stack.push(node);
                node = node.leftNode;
            } else {
                node = stack.pop().rightNode;
                System.out.println(node.data);
            }

        }

    }

    void postorderByStack(Node node) {
        Stack<Node> stack = new Stack<Node>();
        Stack<Node> outStack = new Stack<Node>();
        while (node != null || stack.size() > 0) {
            if (node != null) {
                outStack.push(node);
                stack.push(node);
                node = node.rightNode;
            } else {
                node = stack.pop().leftNode;
            }

        }
        while (outStack.size() > 0) {
            System.out.println(outStack.pop());
        }

    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.test();
    }


    private void postorder(Node node) {
        if (null == node) {
            return;
        }
        postorder(node.leftNode);
        postorder(node.rightNode);
        System.out.println(node.data);
    }


}
