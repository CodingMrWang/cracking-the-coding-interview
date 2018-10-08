import java.util.*;
public class PermutationII {
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
		char[] strs = s.toCharArray();
		Arrays.sort(strs);
		dfs(new String(strs), visited, path, result);
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
			if (i != 0 && s.charAt(i) == s.charAt(i - 1) && !visited[i - 1]) {
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
		PermutationII p = new PermutationII();
		List<String> result = p.Solution("aabc");
		for (String s :result) {
			System.out.println(s);
		}
	}
}