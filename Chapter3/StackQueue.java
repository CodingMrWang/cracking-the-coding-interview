import java.util.Stack;
public class StackQueue {
	Stack<Integer> oldStack;
	Stack<Integer> newStack;
	public StackQueue() {
		oldStack = new Stack<>();
		newStack = new Stack<>();
	}

	public int poll() {
		if (isEmpty()) {
			return -1;
		}
		if (newStack.isEmpty()) {
			transfer();
		} 
		return newStack.pop();
	}

	public void offer(int n) {
		oldStack.push(n);
	}

	private boolean isEmpty() {
		return oldStack.isEmpty() && newStack.isEmpty();
	}

	private void transfer() {
		while (!oldStack.isEmpty()) {
			newStack.push(oldStack.pop());
		}
	}

	public static void main(String[] args) {
		StackQueue stackQueue = new StackQueue();
		stackQueue.offer(1);
		stackQueue.offer(2);
		stackQueue.offer(3);
		System.out.println(stackQueue.poll());
		System.out.println(stackQueue.poll());
		System.out.println(stackQueue.poll());
	}
}
