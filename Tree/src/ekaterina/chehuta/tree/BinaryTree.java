package ekaterina.chehuta.tree;

import java.util.*;

public class BinaryTree<T> {
    private TreeNode<T> root;
    private int count;

    public BinaryTree() {
        root = null;
    }

    //    Получение числа элементов!
    public int getCount() {
        return this.count;
    }

    //    Вставка!
    public void addTreeNode(T data) {
        if (data == null) {
            throw new NullPointerException("Значение элемента null.");
        }

        TreeNode<T> newTreeNode = new TreeNode<>(data);
        count++;

        if (root == null) {
            root = newTreeNode;
        } else {
            TreeNode<T> node = root;

            while (true) {
                if (data.hashCode() < node.getValue().hashCode()) {
                    if (node.getLeftChild() == null) {
                        node.setLeftChild(newTreeNode);
                        return;
                    }

                    node = node.getLeftChild();
                } else {
                    if (node.getRightChild() == null) {
                        node.setRightChild(newTreeNode);
                        return;
                    }

                    node = node.getRightChild();
                }
            }
        }
    }

    //    Поиск узла!
    public boolean contains(T data) {
        if (root == null) {
            throw new NullPointerException("В дереве нет элементов.");
        }

        TreeNode<T> node = root;

        if (data.hashCode() == node.getValue().hashCode()) {
            return true;
        }

        while (data.hashCode() != node.getValue().hashCode()) {
            if (node.getValue().hashCode() > data.hashCode()) {
                node = node.getLeftChild();
            } else {
                node = node.getRightChild();
            }

            if (node == null) {
                return false;
            }
        }

        return true;
    }

    //    Удаление первого вхождения узла по значению!
    public void removeTreeNode(T data) {
        if (root == null) {
            throw new NullPointerException("В дереве нет элементов.");
        }

        TreeNode<T> node = root;
        TreeNode<T> nodeParent = node;
        boolean isLeftChild = false;

        while (data.hashCode() != node.getValue().hashCode()) {
            nodeParent = node;

            if (node.getValue().hashCode() > data.hashCode()) {
                node = node.getLeftChild();
                isLeftChild = true;
            } else {
                node = node.getRightChild();
                isLeftChild = false;
            }

            if (node == null) {
                throw new NullPointerException("В дереве нет элемента.");
            }
        }

        if (node.getLeftChild() == null && node.getRightChild() == null) {
            if (node == root) {
                root = null;
            } else if (isLeftChild) {
                nodeParent.setLeftChild(null);
            } else {
                nodeParent.setRightChild(null);
            }
        } else if (node.getLeftChild() == null || node.getRightChild() == null) {
            if (isLeftChild) {
                if (node.getRightChild() == null) {
                    nodeParent.setLeftChild(node.getLeftChild());
                } else if (node.getLeftChild() == null) {
                    nodeParent.setLeftChild(node.getRightChild());
                }
            } else {
                if (node.getRightChild() == null) {
                    nodeParent.setRightChild(node.getLeftChild());
                } else if (node.getLeftChild() == null) {
                    nodeParent.setRightChild(node.getRightChild());
                }
            }
        } else {
            TreeNode<T> successor = getSuccessor(node);

            if (node == root) {
                root = successor;
            } else if (isLeftChild) {
                nodeParent.setLeftChild(successor);
            } else {
                nodeParent.setRightChild(successor);
            }

            successor.setLeftChild(node.getLeftChild());
        }

        count--;
    }

    private TreeNode<T> getSuccessor(TreeNode<T> deleteNode) {
        TreeNode<T> parentSuccessor = deleteNode;
        TreeNode<T> successor = deleteNode;
        TreeNode<T> node = deleteNode.getRightChild();

        while (node != null) {
            parentSuccessor = successor;
            successor = node;
            node = node.getLeftChild();
        }

        if (successor != deleteNode.getRightChild()) {
            if (successor.getRightChild() != null) {
                parentSuccessor.setLeftChild(successor.getRightChild());
            } else {
                parentSuccessor.setLeftChild(null);
            }

            successor.setRightChild(deleteNode.getRightChild());
        }

        return successor;
    }

    //    Обход в ширину!
    public void traverseTreeInWight() {
        if (root == null) {
            throw new NullPointerException("В дереве нет элементов.");
        }

        TreeNode<T> node = root;
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(node);
        System.out.println("Положили корень " + node.getValue());

        while (queue.size() != 0) {
            node = queue.remove();
            System.out.println("Достали " + node.getValue());

            if (node.getLeftChild() != null) {
                queue.add(node.getLeftChild());
                System.out.printf("Положили %s левого ребенка %s%n", node.getLeftChild().getValue(), node.getValue());
            }

            if (node.getRightChild() != null) {
                queue.add(node.getRightChild());
                System.out.printf("Положили %s правого ребенка %s%n", node.getRightChild().getValue(), node.getValue());
            }
        }
    }

    //    Обход в глубину без рекурсии!
    public void traverseTreeInDepth() {
        if (root == null) {
            throw new NullPointerException("В дереве нет элементов.");
        }

        TreeNode<T> node = root;
        Stack<TreeNode<T>> stack = new Stack<>();
        stack.add(node);
        System.out.println("Положили корень " + node.getValue());

        while (stack.size() != 0) {
            node = stack.pop();
            System.out.println("Достали " + node.getValue());

            if (node.getRightChild() != null) {
                stack.push(node.getRightChild());
                System.out.printf("Положили %s правого ребенка %s%n", node.getRightChild().getValue(), node.getValue());
            }

            if (node.getLeftChild() != null) {
                stack.push(node.getLeftChild());
                System.out.printf("Положили %s левого ребенка %s%n", node.getLeftChild().getValue(), node.getValue());
            }
        }
    }

    //    Обход в глубину с рекурсией!
    public void recursiveTraverseTreeInDepth() {
        if (root == null) {
            throw new NullPointerException("В дереве нет элементов.");
        }

        TreeNode<T> node = root;
        System.out.println("Положили корень " + node.getValue());
        recursive(node);
    }

    private void recursive(TreeNode<T> node) {
        if (node.getLeftChild() != null) {
            System.out.printf("Положили %s левого ребенка %s%n", node.getLeftChild().getValue(), node.getValue());
            recursive(node.getLeftChild());
        }

        if (node.getRightChild() != null) {
            System.out.printf("Положили %s правого ребенка %s%n", node.getRightChild().getValue(), node.getValue());
            recursive(node.getRightChild());
        }
    }

    @Override
    public String toString() {
        TreeNode<T> node = root;
        return treeToString(node);
    }

    private String treeToString(TreeNode<T> node) {
        if (node == null) {
            return "-";
        }

        String leftChild = treeToString(node.getLeftChild());
        String rightChild = treeToString(node.getRightChild());

        return "(" + leftChild + node.getValue() + rightChild + ")";
    }

//    public void printTree() {
//        TreeNode<T> node = root;
//
//        Queue<TreeNode<T>> currentLevel = new LinkedList<>();
//        Queue<TreeNode<T>> nextLevel = new LinkedList<>();
//
//        currentLevel.add(node);
//
//        while (!currentLevel.isEmpty()) {
//            for (TreeNode<T> currentNode : currentLevel) {
//                if (currentNode.getLeftChild() != null) {
//                    nextLevel.add(currentNode.getLeftChild());
//                }
//
//                if (currentNode.getRightChild() != null) {
//                    nextLevel.add(currentNode.getRightChild());
//                }
//
//                System.out.print(currentNode.getValue() + " ");
//            }
//
//            System.out.println();
//            currentLevel = nextLevel;
//            nextLevel = new LinkedList<>();
//
//        }
//
//    }
}
