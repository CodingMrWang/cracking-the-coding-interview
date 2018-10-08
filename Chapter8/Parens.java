import java.util.*;
public class Parens {
	public List<String> Solution (int n) {
		List<String> result = new ArrayList<>();
		List<String> path = new ArrayList<>();
		helper(result, path, n, n);
		return result;
	}
	public void helper(List<String> result,
				  List<String> path,
				  int leftNum,
				  int rightNum) {
		if (rightNum < leftNum) {
			return;
		}
		if (rightNum < 0 || leftNum < 0) {
			return;
		}
		if (leftNum == 0 && rightNum == 0) {
			String temp = "";
			for (String s : path) {
				temp += s;
			}
			result.add(temp);
		}
		path.add("(");
		helper(result, path, leftNum - 1, rightNum);
		path.remove(path.size() - 1);
		path.add(")");
		helper(result, path, leftNum, rightNum - 1);
		path.remove(path.size() - 1);
	}
	public static void main(String[] args) {
		Parens p = new Parens();
		List<String> ans = p.Solution(3);
		for (String s : ans) {
			System.out.println(s);
		}
	}
}