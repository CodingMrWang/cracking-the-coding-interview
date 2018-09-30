public class checkBST {
	Integer min = null;
	Integer max = null;
	public boolean solution(Node root) {
		return checkbst(root, null, null);
	}
	public boolean checkbst(Node root, Integer min, Integer max) {
		if (root == null) {
			return true;
		}
		if (min != null || root.val <= min) {
			return false;
		}
		if (max != null || root.val > max) {
			return flase;
		}
		if (!checkbst(root.left, min, root.val)) {
			return false;
		}
		if (!checkbst(root.right, root.val, max)) {
			return false;
		}
		return true;
	}
} 