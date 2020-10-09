package ekaterina.chehuta.tree;

import java.util.*;
import java.util.function.Consumer;

public class BinaryTree<T extends Comparable<T>> {
    private TreeNode<T> root;
    private int count;

    public BinaryTree() {
    }

    // Получение числа элементов!
    public int getCount() {
        return count;
    }

    // Вставка!
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
                if (data.compareTo(node.getValue()) < 0) {
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

    // Поиск узла!
    public boolean contains(T data) {
        checkRoot(root);

        TreeNode<T> node = root;

        if (data.compareTo(node.getValue()) == 0) {
            return true;
        }

        while (data.compareTo(node.getValue()) != 0) {
            if (node.getValue().compareTo(data) > 0) {
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

    // Удаление первого вхождения узла по значению!
    public void remove(T data) {
        checkRoot(root);

        TreeNode<T> node = root;
        TreeNode<T> nodeParent = node;
        boolean isLeftChild = false;

        while (data.compareTo(node.getValue()) != 0) {
            nodeParent = node;

            if (node.getValue().compareTo(data) > 0) {
                node = node.getLeftChild();
                isLeftChild = true;
            } else {
                node = node.getRightChild();
                isLeftChild = false;
            }

            if (node == null) {
                return;
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

    // Обход в ширину!
    public void traverseTreeInWight(Consumer<T> consumer) {
        if (root == null) {
            return;
        }

        TreeNode<T> node = root;
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(node);

        while (queue.size() != 0) {
            node = queue.remove();
            consumer.accept(node.getValue());

            if (node.getLeftChild() != null) {
                queue.add(node.getLeftChild());
            }

            if (node.getRightChild() != null) {
                queue.add(node.getRightChild());
            }
        }
    }

    // Обход в глубину без рекурсии!
    public void traverseTreeInDepth(Consumer<T> consumer) {
        if (root == null) {
            return;
        }

        TreeNode<T> node = root;
        Stack<TreeNode<T>> stack = new Stack<>();
        stack.add(node);

        while (stack.size() != 0) {
            node = stack.pop();
            consumer.accept(node.getValue());

            if (node.getRightChild() != null) {
                stack.push(node.getRightChild());
            }

            if (node.getLeftChild() != null) {
                stack.push(node.getLeftChild());
            }
        }
    }

    // Обход в глубину с рекурсией!
    public void recursiveTraverseTreeInDepth(Consumer<T> consumer) {
        if (root == null) {
            return;
        }

        TreeNode<T> node = root;
        recursive(node, consumer);
    }

    private void recursive(TreeNode<T> node, Consumer<T> consumer) {
        consumer.accept(node.getValue());

        if (node.getLeftChild() != null) {
            recursive(node.getLeftChild(), consumer);
        }

        if (node.getRightChild() != null) {
            recursive(node.getRightChild(), consumer);
        }
    }

    private void checkRoot(TreeNode<T> node) {
        if (node == null) {
            throw new NullPointerException("В дереве нет элементов.");
        }
    }

    @Override
    public String toString() {
        traverseTreeInWight(t -> System.out.print(t + " "));
        return "";
    }
}
