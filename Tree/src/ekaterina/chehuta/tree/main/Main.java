package ekaterina.chehuta.tree.main;

import ekaterina.chehuta.tree.BinaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();

        binaryTree.addTreeNode(3);
        binaryTree.addTreeNode(2);
        binaryTree.addTreeNode(1);
        binaryTree.addTreeNode(4);
        binaryTree.addTreeNode(5);
        binaryTree.addTreeNode(1);
        binaryTree.addTreeNode(3);
        binaryTree.addTreeNode(2);
        binaryTree.addTreeNode(3);

        System.out.print(binaryTree.getCount());
        System.out.println(binaryTree);

        System.out.println(binaryTree.contains(7));

        binaryTree.removeTreeNode(3);
        System.out.print(binaryTree.getCount());
        System.out.println(binaryTree);
//        binaryTree.printTree();

//        binaryTree.traverseTreeInWight();
//        binaryTree.traverseTreeInDepth();
//        binaryTree.recursiveTraverseTreeInDepth();
    }
}
