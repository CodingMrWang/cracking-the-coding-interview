public class Route {
	boolean search(Node start, Node end) {
		Set<Node> hash = new HashSet<>();
		Queue<Node> queue = new LinkedList<>();
		queue.offer(start);
		while (!queue.isEmpty()) {
			Node n = queue.poll();
			if (n == end) {
				return true;
			}
			if (hash.contains(n)) {
				continue;
			} else {
				hash.add(n);
			}
			for (Node temp : n.neighour) {
				queue.offer(temp);
			}
		}
		return false;
	}
}