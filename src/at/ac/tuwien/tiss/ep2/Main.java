package at.ac.tuwien.tiss.ep2;

public class Main {

    private static TreeNode root = null;

    public static void main(String[] args) {
        printTree();
        System.out.println("Size: " + size());

        remove("Adrian");

        add("Tini");
        System.out.println("Size: " + size());

        printTree();
        remove("Tini");
        printTree();

        add("Adrian");
        add("Tini");
        add("Elsa");
        System.out.println("Size: " + size());
        System.out.println("Levels: " + levels());
        add(42);
        System.out.println("Levels: " + levels());
        add("Claudia");
        System.out.println("Levels: " + levels());
        add("Kai");
        System.out.println("Levels: " + levels());

        System.out.println("Size: " + size());
        System.out.println("Levels: " + levels());

        printTree();

        boolean removed = remove("Adrian");
        if (removed)
            System.out.println("Knoten gelöscht.\n");
        else
            System.out.println("Knoten nicht gelöscht.\n");

        printTree();

        remove("Kai");

        printTree();
        System.out.println("Size: " + size());
        System.out.println("Levels: " + levels());
    }

    private static boolean add(Object value) {
        Body body = null;
        if (value instanceof String) {
            body = new Text((String) value);
        } else if (value instanceof Integer) {
            body = new Number((int) value);
        } else {
            System.out.println(value + " is not a correct instance of types 'String' or 'Integer'.");
            return false;
        }

        if (root == null) {
            root = new TreeNode(body, null, null);
            System.out.println(body.getValue() + " added successfully.");
            return true;
        }
        return root.add(new TreeNode(body, null, null));
    }

    private static void printTree() {
        if (root != null)
            root.printTree();
        else
            System.out.println("Tree is empty.\n");
    }

    private static boolean remove(Object o) {
        // 1. find the correct node to remove
        if (root == null) {
            System.out.println("Tree is empty. " + o.toString() + " cannot be found.");
            return false;
        }
        TreeNode toRemove = root.find(o);
        if (toRemove == null) {
            System.out.println(o.toString() + " not found. It cannot be removed.");
            return false;
        }
        System.out.println("Node found for " + o.toString() + ".");
        TreeNode rightSubtree;
        if (toRemove == root) {
            rightSubtree = root.getRight();
            root = root.getLeft();
            if (root != null && rightSubtree != null)
                root.add(rightSubtree);
            System.out.println(o.toString() + " removed.");
            return true;
        }
        TreeNode parent = root.findParentOf(o);
        System.out.println("Parent found for " + o.toString() + ": " + parent.getBody().getString());
        if (parent.getLeft().equals(toRemove)) {
            // remove my left child: link "left" to "toRemove.getLeft()"
            parent.setLeft(toRemove.getLeft());
            rightSubtree = toRemove.getRight();
            if (rightSubtree != null)
                parent.add(rightSubtree);
            return true;
        }
        parent.setRight(toRemove.getLeft());
        rightSubtree = toRemove.getRight();
        if (rightSubtree != null)
            parent.add(rightSubtree);
        return true;
    }

    private static int size() {
        if (root == null)
            return 0;
        return root.size();
    }

    private static int levels() {
        if (root == null)
            return 0;
        return root.levels();
    }
}
