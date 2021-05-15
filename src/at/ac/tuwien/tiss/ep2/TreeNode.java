package at.ac.tuwien.tiss.ep2;

public class TreeNode {

    private Body body;
    private TreeNode left;
    private TreeNode right;


    public TreeNode(Body body, TreeNode left, TreeNode right) {
        this.body = body;
        this.left = left;
        this.right = right;
    }

    public boolean add(TreeNode newNode) {
        if (newNode.body.getValue().equals(body.getValue())) {
            System.out.println(body.getValue() + " already exists.");
            return false;
        }
        if (newNode.body.getValue().compareTo(body.getValue()) < 0) {
            if (left == null) {
                left = newNode;
                System.out.println(newNode.body.getValue() + " added successfully.");
                return true;
            }
            return left.add(newNode);
        }
        if (right == null) {
            right = newNode;
            System.out.println(newNode.body.getValue() + " added successfully.");
            return true;
        }
        return right.add(newNode);
    }

    public void printTree() {
        // zuerst den linken Baum ausgeben
        if (left != null) {
            left.printTree();
        }
        // dann den aktuellen Knoten ausgeben
        System.out.println(this.body.getValue());
        // dann den rechten Baum ausgeben
        if (right != null) {
            right.printTree();
        }
    }

    public TreeNode find(Object o) {
        if (body.getValue().equals(o.toString())) {
            return this;
        }
        if (body.getValue().compareTo(o.toString()) > 0) {
            if (left != null)
                return left.find(o);
            return null;
        }
        if (right != null)
            return right.find(o);
        return null;
    }

    public TreeNode findParentOf(Object o) {
        if (left != null && left.body.getValue().equals(o.toString()))
            return this;
        if (right != null && right.body.getValue().equals(o.toString()))
            return this;
        if (body.getValue().compareTo(o.toString()) > 0) {
            if (left != null)
                return left.findParentOf(o);
            return null;
        }
        if (right != null)
            return right.findParentOf(o);
        return null;
    }

    public int size() {
        int count = 1;
        if (left != null)
            count += left.size();
        if (right != null)
            count += right.size();
        return count;
    }

    public int levels() {
        int count = 1;
        int leftLevels = 0;
        int rightLevels = 0;
        if (left != null)
            leftLevels = left.levels();
        if (right != null)
            rightLevels = right.levels();
        if (leftLevels > rightLevels)
            return count + leftLevels;
        return count + rightLevels;
    }

    public Body getBody() {
        return body;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
