import java.util.*;
public class BooleanEvaluation {
	public int solution(String s, boolean result) {
		return helper(s, result, new HashMap<>());
	}
	public int helper(String s, boolean result, Map<String, Integer> map) {
		if (s.length() == 0) {
			return 0;
		}
		if (s.length() == 1) {
			if (s.equals("1") && result) {
				return 1;
			} else if (s.equals("0") && (!result)) {
				return 1;
			}
			return 0;
		}
		if (map.containsKey(s + result)) {
			return map.get(s + result);
		}
		int way = 0;
		for (int i = 1; i < s.length(); i+=2) {
			String left = s.substring(0, i);
			String right = s.substring(i + 1);
			int leftTrue = helper(left, true, map);
			int leftFalse = helper(left, false, map);
			int rightTrue = helper(right, true, map);
			int rightFalse = helper(right, false, map);
			int count = 0;
			if (s.charAt(i) == '^') {
				count = leftTrue * rightFalse + leftFalse * rightTrue;
			} else if (s.charAt(i) == '&') {
				count = leftTrue * rightTrue;
			} else if (s.charAt(i) == '|') {
				count = leftTrue * rightTrue + leftTrue * rightFalse + leftFalse * rightTrue;
			}
			if (!result) {
				count = (leftTrue + leftFalse) * (rightTrue + rightFalse) - count;
			}
			way += count;
		}
		map.put(s + result, way);
		return way;
	}
	public static void main(String[] args) {
		BooleanEvaluation be = new BooleanEvaluation();
		System.out.println(be.solution("0^0&0^1&1", true));
	}
}