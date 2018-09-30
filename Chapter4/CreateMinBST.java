class Node {
	int val;
	Node left, right;
	public Node(int val) {
		this.val = val;
	}
}
public class CreateMinBST {
	public Node creatTree(int[] array) {
		return createMinBST(array, 0, array.length - 1);
	}
	public Node createMinBST(int[] array, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = start + (end - start) / 2;
		Node n = new Node(array[mid]);
		n.left = createMinBST(array, start, mid - 1);
		n.right = createMinBST(array, mid + 1, end);
		return n;
	}
}