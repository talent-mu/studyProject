/**
 * 红黑树
 *
 * @author zmh
 * @create 2017-09-13 13:36
 **/
public class BRTree {
    static final boolean COROL_BLACK = true;
    static final boolean COROL_RED = false;

    Node root = null;

    class Node {
        Node parent = null;
        Node leftChild = null;
        Node rightChild = null;
        int value;
        boolean color = COROL_BLACK;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, boolean color) {
            this.value = value;
            this.color = color;
        }
    }

    void insert(int value) {
        if (null == root) {
            root = new Node(value);
            return;
        }
        Node currentNode = root;
        Node parentNode = null;
        while (currentNode != null) {
            parentNode = currentNode;
            if (value < currentNode.value) {
                currentNode = currentNode.leftChild;
            } else {
                currentNode = currentNode.rightChild;
            }
        }
        Node newNode = new Node(value, COROL_RED);
        if (parentNode.value < value) {
            parentNode.rightChild = newNode;
            newNode.parent = parentNode;
        } else {
            newNode.parent = parentNode;
            parentNode.leftChild = newNode;
        }
        fixAfterInsertion(newNode);
    }

    void fixAfterInsertion(Node node) {
        if (node == null || node.parent == null || node.parent.color == COROL_BLACK) {
            return;
        }

        if (parentOf(node) == leftOf(parentOf(parentOf(node)))) {
            Node uncleNode = rightOf(parentOf(parentOf(node)));
            if (colorOf(uncleNode) == COROL_RED) {
                node.parent.parent.leftChild.color = COROL_BLACK;
                node.parent.parent.rightChild.color = COROL_BLACK;
                node.parent.parent.color = COROL_RED;
                fixAfterInsertion(node.parent.parent);
            } else {
                if (node == node.parent.rightChild) {
                    node = node.parent;
                    leftRotate(node);
                }
                node.parent.color = COROL_BLACK;
                node.parent.parent.color = COROL_RED;
                rightRotate(node.parent.parent);
                fixAfterInsertion(node.parent.parent);
            }
        } else {
            Node uncleNode = leftOf(parentOf(parentOf(node)));
            if (colorOf(uncleNode) == COROL_RED) {
                node.parent.color = COROL_BLACK;
                setColor(uncleNode, COROL_BLACK);
                node.parent.parent.color = COROL_RED;
                fixAfterInsertion(node.parent.parent);
            } else {
                if (node == node.parent.leftChild) {
                    node = node.parent;
                    rightRotate(node);
                }
                node.parent.color = COROL_BLACK;
                setColor(parentOf(parentOf(node)), COROL_RED);
                leftRotate(node.parent.parent);
                fixAfterInsertion(node.parent.parent);
            }
        }
        root.color = COROL_BLACK;
    }

    Node parentOf(Node node) {
        return node.parent == null ? null : node.parent;
    }

    Node leftOf(Node node) {
        return node == null ? null : node.leftChild;
    }

    Node rightOf(Node node) {
        return node == null ? null : node.rightChild;
    }

    boolean colorOf(Node node) {
        return node == null ? COROL_BLACK : node.color;
    }

    void setColor(Node node, boolean color) {
        if (null != node) {
            node.color = color;
        }
    }

    void leftRotate(Node point) {
        if (null == root || null == point) {
            return;
        }
        Node pointRight = point.rightChild;
        if (null == point.parent) {
            root = pointRight;
        } else if (point.parent.leftChild == point) {
            point.parent.leftChild = pointRight;
        } else if (point.parent.rightChild == point) {
            point.parent.rightChild = pointRight;
        }
        pointRight.parent = point.parent;
        point.parent = pointRight;
        point.rightChild = pointRight.leftChild;
        if (null != point.rightChild) {
            point.rightChild.parent = point;
        }
        pointRight.leftChild = point;
    }

    void rightRotate(Node point) {
        if (null == root || null == point) {
            return;
        }
        Node pointLeft = point.leftChild;
        if (null == point.parent) {
            root = pointLeft;
        } else if (point.parent.leftChild == point) {
            point.parent.leftChild = pointLeft;
        } else if (point.parent.rightChild == point) {
            point.parent.rightChild = pointLeft;
        }
        pointLeft.parent = point.parent;
        point.parent = pointLeft;
        point.leftChild = pointLeft.rightChild;
        if (point.leftChild != null) {
            point.leftChild.parent = point;
        }
        pointLeft.rightChild = point;
    }

    void inorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value + "       " + (node.color == true ? "black" : "red") + "        L:" + (node
                .leftChild ==
                null ? "null" : node.leftChild.value) + "       R:" + (node.rightChild == null ? "null" : node
                .rightChild.value)
                + "       P:" + (node.parent == null ? "null" : node.parent.value));
        inorder(node.leftChild);
        inorder(node.rightChild);
    }

    boolean checkBRTree() {
        int blackNum = 0;


        return true;
    }
    int blackNum = 0;
    int getBNum(Node node, Integer count) {
        if (null == count) {
            count = 0;
        }
        if (node == null) {
            return 0;
        }
        if (node.color == COROL_BLACK) {
            count += 1;
        }
        if (node.leftChild != null) {
            count += getBNum(node.leftChild,count);
        } else if (node.rightChild != null) {
            count += getBNum(node.rightChild,count);
        }else {
            if (blackNum == 0) {
                blackNum = count;
                System.out.println(blackNum);
            }
            System.out.println(count == blackNum);
        }
        return count;
    }

    public static void main(String[] args) {
        BRTree brTree = new BRTree();
        for (int i = 0; i < 100; i++) {
            brTree.insert(i);
        }
//        brTree.insert(5);
//        brTree.inorder(brTree.root);
//        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//        brTree.insert(8);
//        brTree.inorder(brTree.root);
//        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//        brTree.insert(23);
//        brTree.inorder(brTree.root);
//        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//        brTree.insert(45);
//        brTree.inorder(brTree.root);
//        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//        brTree.insert(65);
//        brTree.inorder(brTree.root);
//        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//        brTree.insert(13);
//        brTree.inorder(brTree.root);
//        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//        brTree.insert(12);
//        brTree.inorder(brTree.root);
//        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//        brTree.insert(16);
//        brTree.inorder(brTree.root);
//        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//        brTree.insert(19);
//        brTree.inorder(brTree.root);
//        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//        brTree.insert(89);
//        brTree.inorder(brTree.root);
//        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//        brTree.insert(67);
//        brTree.insert(66);
//        brTree.insert(68);
        brTree.inorder(brTree.root);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        brTree.getBNum(brTree.root,0);
    }
}
