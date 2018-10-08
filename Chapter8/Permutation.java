import java.util.*;
public class Permutation {
	public List<String> Solution(String s) {
		List<String> result = new ArrayList<>();
		if (s == null) {
			return result;
		}
		if (s.length() == 0) {
			result.add("");
			return result;
		}
		List<String> path = new ArrayList<>();
		boolean[] visited = new boolean[s.length()];
		dfs(s, visited, path, result);
		return result;
	}

	public void dfs(String s,
					boolean[] visited,
					List<String> path,
					List<String> result) {
		if (path.size() == s.length()) {
			String temp = "";
			for (String ss : path) {
				temp += ss;
			}
			result.add(temp);
		}
		for (int i = 0; i < s.length(); i++) {
			if (visited[i]) {
				continue;
			}
			visited[i] = true;
			path.add(s.charAt(i) + "");
			dfs(s, visited, path, result);
			path.remove(path.size() - 1);
			visited[i] = false;
		}
	}
	public static void main(String[] args) {
		Permutation p = new Permutation();
		List<String> result = p.Solution("abc");
		for (String s :result) {
			System.out.println(s);
		}
	}
}