public class MagicIndexII {
	public int Solution(int[] arr) {
		return search(arr, 0, arr.length - 1);
	}
	public int search(int[] arr, int left, int right) {
		if (right <= left) {
			return -1;
		}
		int mid = left + (right - left) / 2;
		int midValue = arr[mid];
		if (mid == midValue) {
			return mid;
		}
		// if midIndex > midValue, at least go to midValue index
		int leftIndex = Math.min(mid - 1, midValue);
		int leftV = search(arr, left, leftIndex);
		if (leftV >= 0) {
			return leftV;
		}
		int rightIndex = Math.max(mid + 1, midValue);
		int rightV = search(arr, rightIndex, right);
		return rightV;
	}
	public static void main(String[] args) {
		MagicIndexII mi = new MagicIndexII();
		System.out.println(mi.Solution(new int[]{-10, -9, 2, 2, 2, 3, 4, 7, 9, 12, 13}));
	}
}