public class FlipBit {
	public int solution(int n) {
		if (n == -1) {
			return String.valueOf(n).length();
		}
		int currentLength = 0;
		int prevLength = 0;
		int max = 1;
		while (n != 0) {
			if ((n & 1) == 1) {
				currentLength += 1;
			} else {
				if ((n & 2) == 0) {
					prevLength = 0;
				} else {
					prevLength = currentLength;
				}
				currentLength = 0;
			}
			max = Math.max(prevLength + currentLength + 1, max);
			n = n >>> 1;
		}
		return max;
	}
	public static void main(String[] args) {
		FlipBit fb = new FlipBit();
		System.out.println(fb.solution(1783));
	}
}