package ekaterina.chehuta.tree;

public class TreeNode<T extends Comparable<T>> implements Comparable<TreeNode<T>> {
    private T value;
    private TreeNode<T> leftChild;
    private TreeNode<T> rightChild;

    public TreeNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public TreeNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public int compareTo(TreeNode<T> o) {
        return value.compareTo(o.getValue());
    }
}
