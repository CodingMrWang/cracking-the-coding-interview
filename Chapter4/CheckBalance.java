public CheckBalance {
	boolean result = true;
	public boolean solution(Node root) {
		if (root == null) {
			return false;
		}
		getHeight(root);
		return result;
	}
	public int getHeight(Node root) {
		if (root == null) {
			return 0;
		}
		int leftheight = getHeight(root.left);
		int rightheight = getHeight(root.right);
		if (Math.abs(leftheight - rightheight) > 1) {
			result = false;
		}
		return Math.max(leftheight, rightheight) + 1;
	}
}