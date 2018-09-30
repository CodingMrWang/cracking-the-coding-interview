public class BSTSuccessor {
	public Node inorderSuccessor(Node n) {
		if (n == null) {
			return n;
		}
		if (n.right != null) {
			return leftMost(n.right);
		}
		Node temp = n;
		Node p = temp.parent;
		while (p != null && p.left != temp) {
			temp = p;
			p = p.parent;
		}
		return p;
	}

	public Node leftMost(Node n) {
		while (n != null && n.left != null) {
			n = n.left;
		}
		return n;
	}
}