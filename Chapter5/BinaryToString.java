public class BinaryToString {
	public String solution(double num) {
		if (num >= 1 || num <= 0) {
			return "ERROR";
		}
		double frac = 0.5;
		StringBuilder result = new StringBuilder();
		result.append(".");
		while (num > 0) {
			if (result.length() > 32) {
				return "ERROR";
			}
			if (num >= frac) {
				result.append("1");
				num -= frac;
			} else {
				result.append("0");
			}
			frac /= 2;
		}
		return result.toString();
	}
	public static void main(String[] args) {
		BinaryToString bs = new BinaryToString();
		System.out.println(bs.solution(0.125));
	}
}