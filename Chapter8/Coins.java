public class Coins {
	public int Solution(int n) {
		int[] coins = {25, 10, 5, 1};
		int[][] hash = new int[n + 1][coins.length];
		return helper(hash, coins, n, 0);
	}

	public int helper(int[][] hash, int[] coins, int n, int index) {
		if (index >= coins.length - 1) {
			return 1;
		}
		if (hash[n][index] > 0) {
			return hash[n][index];
		}
		int value = coins[index];
		int way = 0;
		for (int i = 0; i <= n / value; i++) {
			way += helper(hash, coins, n - i * value, index + 1);
		}
		hash[n][index] = way;
		return way;
	}
	public static void main(String[] args) {
		Coins c = new Coins();
		System.out.println(c.Solution(100));
	}
}