public class LCA {
	public Node findLCA(Node root, Node A, Node B) {
		if (root == null) {
			return root;
		}
		if (root == null || root == A || root == B) {
			return root;
		}
		Node left = findLCA(root.left, A, B);
		Node right = findLCA(root.right, A, B);
		if (left != null && right != null) {
			return root;
		}
		if (left != null) {
			return left;
		}
		if (right != null) {
			return right;
		}
		return null;
	}
}