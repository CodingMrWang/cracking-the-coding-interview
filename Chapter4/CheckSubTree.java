public class CheckSubTree {
	public boolean containTree(Node n1, Node n2) {
		if (n2 == null) {
			return true;
		}
		return helper(n1, n2);
	}
	public boolean helper(Node n1, Node n2) {
		if (n1 == null) {
			return false;
		} else if (n1.val == n2.val && matchTree(n1, n2)) {
			return true;
		} 
		return helper(n1.left, n2) || helper(n1.right, n2);
	}
	boolean matchTree(Node n1, Node n2) {
		if (n1 == nulll && n2 == null) {
			return true;
		} else if (n1 == null || n2 == null) {
			return false;
		} else if (n1.val != n2.val) {
			return false;
		} else {
			return matchTree(n1.left, n2.left) && matchTree(n1.right, n2.right);
		}
	}
}