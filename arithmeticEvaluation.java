/*
 Suppose an arithmetic expression is given as a binary tree. Each leaf is an integer 
 and each internal node is one of '+', '−', '∗', or '/'.

Given the root to such a tree, write a function to evaluate it.

For example, given the following tree:

    *
   / \
  +    +
 / \  / \
3  2  4  5
You should return 45, as it is (3 + 2) * (4 + 5).
*/

public class arithmeticEvaluation {
	public static void main(String args[]) {
		Node root = new Node();
		root.value = "*";
		Node left = new Node();
		left.value = "+";
		Node right = new Node();
		right.value = "+";
		root.left = left;
		root.right = right;
		
		Node leaf1 = new Node();
		leaf1.value = "3";
		
		Node leaf2 = new Node();
		leaf2.value = "2";
		Node leaf3 = new Node();
		leaf3.value = "4";
		Node leaf4 = new Node();
		leaf4.value = "5";
		
		left.left = leaf1;
		left.right = leaf2;
		
		right.left = leaf3;
		right.right = leaf4;
		int result = evaluateExpressionTree(root);
		System.out.println(result);
	}

	private static int evaluateExpressionTree(Node root) {
		if(!isOperator(root.value)) {
			return Integer.parseInt(root.value);
		}
		
		int leftVal = evaluateExpressionTree(root.left);
		int rightVal = evaluateExpressionTree(root.right);
		
		switch(root.value) {
		case "+":
			return leftVal + rightVal;
			
		case "-":
			return leftVal - rightVal;
			
		case "*":
			return leftVal * rightVal;
			
		case "/":
			return leftVal / rightVal;
			
		default:
			return -1;
		}
		
	}

	private static boolean isOperator(String s) {
		
		if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
			return true;
		}
		return false;
	}

}

class Node {
	String value;
	Node left;
	Node right;
}
