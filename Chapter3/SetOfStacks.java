import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SetOfStacks {
	List<Stack<Integer>> stacks;
	final int threshold =2;
	public SetOfStacks() {
		stacks = new ArrayList<>();
	}
	public void push(int n) {
		if (stacks.size() == 0) {
			stacks.add(new Stack<>());
		}
		if (stacks.get(stacks.size() - 1).size() >= threshold) {
			stacks.add(new Stack<>());
		}
		stacks.get(stacks.size() - 1).push(n);
	}
	public int pop() {
		if (stacks.size() == 0) {
			return -1;
		}
		Stack<Integer> temp = stacks.get(stacks.size() - 1);
		int ans = temp.pop();
		if (temp.size() == 0) {
			stacks.remove(stacks.size() - 1);
		}
		return ans;
	}

	public static void main(String[] args) {
		SetOfStacks setStack = new SetOfStacks();
		setStack.push(2);
		setStack.push(3);
		setStack.push(4);
		setStack.push(5);
		System.out.println(setStack.pop());
		System.out.println(setStack.pop());
		System.out.println(setStack.pop());
		System.out.println(setStack.pop());
	}
}