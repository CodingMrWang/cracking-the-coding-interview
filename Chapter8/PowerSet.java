import java.util.*;
public class PowerSet {
	public List<List<Integer>> Solution(int[] arr) {
		List<List<Integer>> result = new ArrayList<>();
		if (arr == null) {
			return result;
		}
		if (arr.length == 0) {
			result.add(new ArrayList<>());
			return result;
		}
		Arrays.sort(arr);
		List<Integer> path = new ArrayList<>();
		dfs(arr, 0, result, path);
		return result;
	}

	public void dfs(int[] arr,
					int index,
					List<List<Integer>> result,
					List<Integer> path) {
		result.add(new ArrayList<>(path));
		// {1, 2, 2, 4} if current is the second 2, then will continue, duplicate
		for (int i = index; i < arr.length; i++) {
			if (i != index && arr[i] == arr[i - 1]) {
				continue;
			}
			path.add(arr[i]);
			dfs(arr, i + 1, result, path);
			path.remove(path.size() - 1);
		}
	}
	public static void main(String[] args) {
		PowerSet ps = new PowerSet();
		List<List<Integer>> result = ps.Solution(new int[] {4, 2, 2, 1});
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
}