public class TreeLecture {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(20);
        tree.insert(20);
        tree.insert(20);
        tree.insert(30);
        tree.insert(60);
        tree.insert(80);
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
            System.out.println("\n Size of tree: "+tree.getSize(tree.root));
            System.out.println("\n Search tree: "+tree.searchInTree(tree.root, 0));
            System.out.println("Max value: "+tree.getMaxValue(tree.root));
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
    
        public int getSize(TreeNode root){
            if(root == null) return 0;
            else return 1+ getSize(root.left) + getSize(root.right);
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
    
            if (data <= root.data) {
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

        private boolean searchInTree(TreeNode root, int value) {
            if (root == null)  return false;
            if (value == root.data) 
                return true;
            if (value < root.data) 
                return searchInTree(root.left, value);
            return searchInTree(root.right, value);
      }

      public int getMaxValue(TreeNode root) {
        if(root == null) return -1;

        // while(root.right != null) root = root.right;

        // return root.data;

        if(root.right==null) return root.data;
        return getMaxValue(root.right);
      }

      public int getMinValue(TreeNode root) {
        if(root == null) return -1;

        // while(root.right != null) root = root.right;

        // return root.data;

        if(root.left==null) return root.data;
        return getMaxValue(root.left);
      }
    }
    
}
