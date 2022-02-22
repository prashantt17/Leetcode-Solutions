package Trees;

import java.util.Scanner;

class TreeNode {

	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	};

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class Sum_of_Left_Leaves_404 {
	static final int COUNT = 5;
	static Scanner sc = null;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		TreeNode root = createTreeNode();
		//int[] nodes =  {3,9,20,-1,-1,15,7};
		int sum = sumOfLeftLeaves(root);
		System.out.println("SUM : " + sum);
		
		int max = maxDepth(root);
		System.out.println("MAX" + max);
	}

	static TreeNode createTreeNode() {
		TreeNode root = null;
		System.out.print("Enter node value : ");
		int value = sc.nextInt();

		if (value == -1)
			return null;
		root = new TreeNode(value);

		System.out.println("Enter left node value for :" + value);
		root.left = createTreeNode();

		System.out.println("Enter right node value :" + value);
		root.right = createTreeNode();

		return root;
	}

	static int sumOfLeftLeaves(TreeNode root) {
		if (root == null) {
			return 0;
		} else if (root.left != null && root.left.left == null && root.left.right == null) {
			return root.left.val + sumOfLeftLeaves(root.right);
		} else {
			return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
		}
	}

	static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right) + 1;
    }
}
