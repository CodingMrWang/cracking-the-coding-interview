import java.util.Stack;


public class MinStack {
	Stack<Integer> stack;
	Stack<Integer> minStack;
	public MinStack() {
		stack = new Stack<>();
		minStack = new Stack<>();
	}
	public void push(int n) {
		if (stack.isEmpty()) {
			stack.push(n);
			minStack.push(n);
			return;
		}
		int curMin = minStack.peek();
		stack.push(n);
		if (curMin <= n) {
			minStack.push(minStack.peek());
		} else {
			minStack.push(n);
		}
	}
	public int pop() {
		if (stack.isEmpty()) {
			return -1;
		}
		minStack.pop();
		return stack.pop();
	}
	public int min() {
		return minStack.peek();
	}

	public static void main(String[] args) {
		// test
		MinStack minStack = new MinStack();
		minStack.push(4);
		minStack.push(2);
		minStack.push(3);
		minStack.push(1);
		System.out.println(minStack.min());
		System.out.println(minStack.pop());
		System.out.println(minStack.min());
	}
}