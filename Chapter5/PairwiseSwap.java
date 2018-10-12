public class PairwiseSwap {
	public int swap(int x) {
		return (((x & 0xaaaaaaaa) >>> 1) | ((x & 0x55555555) << 1));
	}
	public static void main(String[] args) {
		PairwiseSwap ps = new PairwiseSwap();
		System.out.println(ps.swap(25));
	}
}