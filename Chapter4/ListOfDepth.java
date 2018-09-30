// bfs
public class ListOfDepth {
	public List<LinkedList<Node>> getListDepth(Node root) {
		List<LinkedList<Node>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		LinkedList<Node> temp = new LinkedList<>();
		temp.add(root);
		result.add(temp);
		Queue<Node> queue = new LinkedList<>();

		while (!queue.isEmpty()) {
			Node n = queue.poll();
			int size = queue.size();
			LinkedList<Node> step = new LinkedList<>();
			for (int i = 0; i < size; i++) {
				Node t = queue.poll();
				step.add(t);
				if (t.left != null) {
					queue.offer(t.left);
				}
				if (t.right != null) {
					queue.offer(t.right);
				}
			}
			result.add(step);
		}
	}
}