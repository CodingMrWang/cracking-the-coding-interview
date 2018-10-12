public class Coversion {
	public int solution(int a, int b) {
		int c = a ^ b;
		int count = 0;
		// c & (c - 1) will clear least significant 1;
		while (c != 0) {
			// if ((c & 1) == 1) {
			// 	count++;
			// }
			// c = c >>1;
			count++;
			c = c & (c - 1);
		}
		return count;
	}

	public static void main(String[] args) {
		Coversion c = new Coversion();
		System.out.println(c.solution(29, 15));
	}
}