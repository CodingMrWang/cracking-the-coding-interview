public class PathSum {
	int ans = 0;
	public int solution (Node n, int target) {
		List<Integer> path = new ArrayList<>();
		dfs(n, 0, target, path);
		return ans;
	}
	public void dfs(Node n, int level, int target, List<Integer> path) {
		if (n == null) {
			return;
		}
		path.add(n.val);
		int sum = 0;
		for (int i = level; i >= 0; i--) {
			sum += path.get(i);
			if (sum == target) {
				ans++;
				break;
			}
		}
		dfs(root.left, level + 1, target, path);
		dfs(root.right, level + 1, target, path);
		path.remove(path.size() - 1);
	}
}