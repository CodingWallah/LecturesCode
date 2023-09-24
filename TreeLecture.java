public class TreeLecture {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(20);
        tree.insert(80);
        tree.insert(60);
        tree.insert(30);
            // tree.insert(50);
            // tree.insert(30);
            // tree.insert(20);
            // tree.insert(40);
            // tree.insert(70);
            // tree.insert(60);
            // tree.insert(80);
            System.out.println("Root "+tree.getroot());
            System.out.println("In-order traversal (sorted order):");
            tree.printInOrder(); // Output: 20 30 40 50 60 70 80
            System.out.print("\n Pre-order traversal ");
            tree.printPreOrder();
             System.out.print("\n Post-order traversal ");
            tree.printPostOrder();
    }

   public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
    
        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    public static class BinaryTree {
        TreeNode root;
    
        public BinaryTree() {
            root = null;
        }
    
        public int getroot() {
            return root.data;
        }

        public void insert(int data) {
            root = insertRec(root, data);
        }
    
        private TreeNode insertRec(TreeNode root, int data) {
            if (root == null) {
                root = new TreeNode(data);
                return root;
            }
    
            if (data < root.data) {
                root.left = insertRec(root.left, data);
            } else if (data > root.data) {
                root.right = insertRec(root.right, data);
            }
    
            return root;
        }
    
        public void printInOrder() {
            printInOrderRec(root);
        }
    
        private void printInOrderRec(TreeNode root) {
            if (root != null) {
                printInOrderRec(root.left);
                System.out.print(root.data + " ");
                printInOrderRec(root.right);
            }
        }

        public void printPreOrder() {
            printPreOrderRec(root);
        }
    
        private void printPreOrderRec(TreeNode root) {
            if (root != null) {
                System.out.print(root.data + " ");
                printPreOrderRec(root.left);
                 printPreOrderRec(root.right);
            }
        }

         public void printPostOrder() {
            printPostOrderRec(root);
        }
    
        private void printPostOrderRec(TreeNode root) {
            if (root != null) {
                printPostOrderRec(root.left);
                 printPostOrderRec(root.right);
                 System.out.print(root.data + " ");
            }
        }

    }
    
}
