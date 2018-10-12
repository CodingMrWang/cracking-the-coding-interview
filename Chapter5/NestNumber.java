public class NestNumber {
	public int solution1(int n) {
		int c = n;
		int c0 = 0;
		int c1 = 0;
		while ((c & 1) == 0 && c != 0) {
			c0++;
			c = c >> 1;
		}
		while ((c & 1) == 1) {
			c1++;
			c = c >> 1;
		}
		if (c0 + c1 == 31 || c0 + c1 == 0) {
			return -1;
		}
		int p = c0 + c1;
		n |= (1 << p);
		n &= ~(1 << (p) - 1);
		n |= (1 << (c1 - 1)) - 1;
		return n;
	}
	public int solution2(int n) {
		int c = n;
		int c0 = 0;
		int c1 = 0;
		while ((c & 1) == 1) {
			c1++;
			c = c >> 1;
		}
		while ((c & 1) == 0 && c != 0) {
			c0++;
			c = c >> 1;
		}
		if (c0 + c1 == 31 || c0 + c1 == 0) {
			return -1;
		}
		int p = c0 + c1;
		n &= ((~0) << (p + 1));
		int mask  = 1 << (c1 + 1) - 1;
		n |= mask << (c0 - 1);
		return n;
	}
	public static void main(String[] args) {
		NestNumber nn = new NestNumber();
		System.out.println(nn.solution1(14076));
		System.out.println(nn.solution2(14051));
	}
}