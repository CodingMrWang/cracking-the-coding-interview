public class Insertion {
	public int solution(int n, int m, int i, int j) {
		int allone = ~0;
		int leftMask = allone << (j + 1);
		int rightMask = (1 << i) - 1;
		int mask = leftMask | rightMask;
		n = n & mask;
		m = m << i;
		return n | m;
	}
	public static void main(String[] args) {
		Insertion i = new Insertion();
		System.out.println(i.solution(100, 20, 1, 6));
	}
}