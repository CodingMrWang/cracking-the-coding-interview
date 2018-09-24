import java.util.Stack;
public class SortStack {
	public void sortStack(Stack<Integer> stack) {
		Stack<Integer> sortStack = new Stack<>();
		while (!stack.isEmpty()) {
			if (sortStack.isEmpty()) {
				sortStack.push(stack.pop());
				continue;
			}
			int temp = stack.peek();
			if (temp < sortStack.peek()) {
				stack.pop();
				while (!sortStack.isEmpty() && temp < sortStack.peek()) {
					stack.push(sortStack.pop());
				}
				sortStack.push(temp);
				continue;
			}
			sortStack.push(stack.pop());
		}
		while (!sortStack.isEmpty()) {
			stack.push(sortStack.pop());
		}
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(3);
		stack.push(7);
		stack.push(2);
		stack.push(9);
		stack.push(3);
		SortStack SS = new SortStack();
		SS.sortStack(stack);
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
}