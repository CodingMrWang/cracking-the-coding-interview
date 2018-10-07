public class TripleStep {
	public int Solution(int steps) {
		int[] f = new int[3];
		f[0] = 1;
		f[1] = 1;
		for (int i = 2; i <= steps; i++) {
			if (i == 2) {
				f[i] = f[i - 2] + f[i - 1];
				continue;
			}
			f[i % 3] = f[(i - 3) % 3] + f[(i - 2) % 3] + f[(i - 1) % 3];
		}
		return f[steps % 3];
	}
	public static void main(String[] args) {
		TripleStep s = new TripleStep();
		System.out.println(s.Solution(Integer.parseInt(args[0])));
	}
}