import java.util.*;
public class RecursiveMultiply {
	public int Solution(int a, int b) {
		int small = a < b ? a : b;
		int large = a < b ? b : a;
		int ans = helper(small, large);
		return ans;
	}
	Map<Integer, Integer> hash = new HashMap<>();
	public int helper(int a, int b) {
		if (a == 0) {
			return 0;
		}
		if (a == 1) {
			return b;
		}
		if (hash.containsKey(a)) {
			return hash.get(a);
		}
		int small = a >> 1;
		int temp = helper(small, b);
		int ans = temp;
		if( a % 2 == 1) {
			ans += temp + b;
		} else {
			ans += temp;
		}
		hash.put(a, ans);
		return ans;
	}
	public static void main(String[] args) {
		RecursiveMultiply rm = new RecursiveMultiply();
		System.out.println(rm.Solution(10, 5));
	}
}