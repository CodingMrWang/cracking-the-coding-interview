import java.util.*;
class Box {
	int w, h, d;
	public Box(int w, int h, int d) {
		this.w = w;
		this.h = h;
		this.d = d;
	}
}

public class StackBox {
	public int solution(List<Box> boxes) {
		Collections.sort(boxes, new Comparator<Box>() {
			public int compare(Box box1, Box box2) {
				return box2.h - box1.h;
			}
		});
		int[] hash = new int[boxes.size()];
		return helper(boxes, hash, 0, new ArrayList<>());
	}
	public int helper(List<Box> boxes, int[] hash, int index, List<Box> path) {
		if (index >= boxes.size()) {
			return 0;
		}
		
		Box bottom = boxes.get(index);
		int height1 = 0;
		if (path.size() == 0 || valid(bottom, path.get(path.size() - 1))) {
			if (hash[index] == 0) {
				path.add(bottom);
				hash[index] = helper(boxes, hash, index + 1, path) + bottom.h;
				path.remove(path.size() - 1);
			}
		}
		height1 = hash[index];
		int height2 = helper(boxes, hash, index + 1, path);
		int maxHeight = Math.max(height1, height2);
		return maxHeight;
	}
	public static void main(String[] args) {
		Box b1 = new Box(10, 10, 10);
		Box b2 = new Box(30, 11, 20);
		Box b3 = new Box(4, 10, 50);
		Box b4 = new Box(10, 10, 10);
		Box b5 = new Box(10, 10, 10);
		List<Box> list = new ArrayList<>();
		list.add(b1);
		list.add(b2);
		list.add(b3);
		list.add(b4);
		list.add(b5);
		StackBox s = new StackBox();
		System.out.println(s.solution(list));
	}

	private boolean valid(Box box1, Box box2) {
		return !(box1.h >= box2.h || box1.w >= box2.w || box1.d >= box2.d);
	}
}