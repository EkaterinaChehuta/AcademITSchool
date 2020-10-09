package ekaterina.chehuta.tree.main;

import ekaterina.chehuta.tree.BinaryTree;

import java.util.function.Consumer;

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

        System.out.printf("(%s)",binaryTree.getCount());
        System.out.println(binaryTree);

        System.out.println(binaryTree.contains(7));

        binaryTree.remove(3);
        System.out.printf("(%s) ",binaryTree.getCount());
        System.out.println(binaryTree);

        binaryTree.traverseTreeInWight(integer -> System.out.print(integer + " "));
        System.out.println();

        binaryTree.traverseTreeInDepth(integer -> System.out.print(integer + " "));
        System.out.println();

        binaryTree.recursiveTraverseTreeInDepth(integer -> System.out.print(integer + " "));
    }
}
