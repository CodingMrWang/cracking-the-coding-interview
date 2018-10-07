public class MagicIndex {
	public int Solution(int[] arr) {
		return search(arr, 0, arr.length - 1);
	}
	public int search(int[] arr, int left, int right) {
		if (right < left) {
			return -1;
		}
		int mid = left + (right - left) / 2;
		if (arr[mid] < mid) {
			return search(arr, mid, right);
		} else if (arr[mid] > mid) {
			return search(arr, left, mid);
		} else {
			return mid;
		}
	}
	public static void main(String[] args) {
		MagicIndex mi = new MagicIndex();
		int[] arr = new int[]{-1, 0, 2, 6};
		System.out.println(mi.Solution(arr));
	}
}