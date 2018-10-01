public class RandomNode {
	int data;
	RandomNode left, right;
	int size;
	public RandomNode(int data) {
		this.data = data;
		this.size = 1;
	}
	public void insert(int d) {
		if (d <= data) {
			if (left != null) {
				left.insert(d);
			} else {
				left = new RandomNode(d);
			}
		} else {
			if (right != null) {
				right.insert(d);
			} else {
				right = new RandomNode(d);
			}
		}
		size++;
	}
	public RandomNode getRandom() {
		int leftsize = 0;
		if (left != null) {
			leftsize = left.size;
		}
		Random ran = new Random();
		int index = ran.nextInt(this.size);
		if (index < leftsize) {
			return left.getRandom();
		} else if (index > leftsize) {
			return right.getRandom();
		} else {
			return this;
		}
	}
	public RandomNode find(int d) {
		if (d == data) {
			return this;
		} else if (d <= data) {
			if (left != null) {
				return left.find(d);
			} else {
				return null;
			}
		} else {
			if (right != null) {
				return right.find(d);
			} else {
				return null;
			}
		}
	}
}