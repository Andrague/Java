import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public String toString() {
        return Integer.toString(data);
    }
}

public class Tree {
    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public Tree() {
        this.root = null;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private TreeNode insertRec(TreeNode root, int value) {
        if (root == null) { 
            root = new TreeNode(value);
            return root;
        }

        if (value < root.data) {
            root.left = insertRec(root.left, value);
        } else if (value > root.data) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    public void printTree() {
        printTree(root);
    }

    private void printTree(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            printTree(root.left);
            printTree(root.right);
        }
    }

    public List<Integer> inorderTraversal() {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        for (int value : result) {
            System.out.print(value + " ");
        }

        return result;
    }

    private void inorderTraversal(TreeNode root, List<Integer> result) {
        if (root != null) {
            inorderTraversal(root.left, result);
            result.add(root.data);
            inorderTraversal(root.right, result);
        }
    }

    public int getHeight() {
        return getHeightRec(root);
    }

    private int getHeightRec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeightRec(root.left);
        int rightHeight = getHeightRec(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        Tree bst = new Tree();
        Set<Integer> generatedNumbers = new HashSet<>();
        Scanner reader = new Scanner(System.in);

        System.out.println("Enter a size of tree: ");
        int n = reader.nextInt();
        Random random = new Random();

        while (generatedNumbers.size() < n) {
            int randomNumber = random.nextInt(100);
            if (generatedNumbers.add(randomNumber)) {
                bst.insert(randomNumber);
            }
        }

        System.out.println("Tree Structure (Pre-order):");
        bst.printTree();
        System.out.println("\nInorder Traversal List:");
        bst.inorderTraversal();
        System.out.println("\nTree Height: " + bst.getHeight());
        bst.insert(12);
        bst.printTree();

        ArrayList<Integer> sets = new ArrayList<>();
        ArrayList<Integer> times= new ArrayList<>();
        ArrayList<Integer> dataForTree = new ArrayList<>();
        ArrayList<Long> bubbleSortTimes = new ArrayList<>();
        Random random1 = new Random();

        for (int datasetSize = 1000; datasetSize <= 10000; datasetSize += 1000) {
        	long timeOfBubbleSort = 0;
            long totalTreeSortTime= 0;
            for (int trial = 0; trial < 100; trial++) {
                generatedNumbers.clear();
                dataForTree.clear();
                while (generatedNumbers.size() < datasetSize) {
                    int randomNumber = random1.nextInt(10000);
                    if (generatedNumbers.add(randomNumber)) {
                        dataForTree.add(randomNumber);
                    }
            }
            
                // Tree Sort
                Tree bst1 = new Tree();
                for (int num : dataForTree) {
                    bst1.insert(num);
                }

                long startTime = System.nanoTime();
                bst1.inorderTraversal(); // Use bst1 here
                long endTime = System.nanoTime();
                totalTreeSortTime = (endTime - startTime); 
                
                ArrayList<Integer> generatedList = new ArrayList<>(generatedNumbers);
                long startBubbleSort = System.nanoTime();
                for (int i = 0; i < generatedList.size() - 1; i++) {
                    for (int j = 0; j < generatedList.size() - i - 1; j++) {
                        if (generatedList.get(j) > generatedList.get(j + 1)) {
                            int temp = generatedList.get(j);
                            generatedList.set(j, generatedList.get(j + 1));
                            generatedList.set(j + 1, temp);
                        }
                    }
                }
                long endBubbleSort = System.nanoTime();
                timeOfBubbleSort = endBubbleSort - startBubbleSort;
                

                
            }
            times.add( (int) totalTreeSortTime );
            bubbleSortTimes.add(timeOfBubbleSort);
            sets.add(datasetSize);
    }
        

        System.out.println("\nBubble Sorting time: ");
        for (int i = 0; i < bubbleSortTimes.size(); i++) {
            System.out.print(bubbleSortTimes.get(i));
            if (i < bubbleSortTimes.size() - 1) {
                System.out.print(",");
            }
        }

        // Print dataset sizes
        System.out.println("\nSets: ");
        for (int i = 0; i < sets.size(); i++) {
            System.out.print(sets.get(i));
            if (i < sets.size() - 1) {
                System.out.print(",");
            }
        }

        // Print times for Tree Sort
        System.out.println("\nTree Sorting time: ");
        for (int i = 0; i < times.size(); i++) {
            System.out.print(times.get(i));
            if (i < times.size() - 1) {
                System.out.print(",");
            }
        }
    }
}
