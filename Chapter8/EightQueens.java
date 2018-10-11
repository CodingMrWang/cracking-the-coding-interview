import java.util.*;
public class EightQueens {
	public List<int[]> solution() {
		List<int[]> result = new ArrayList<>();
		int[] columns = new int[8];
		dfs(0, columns, result);
		return result;
	}
	public void dfs(int row, int[] columns, List<int[]> result) {
		if (row == 8) {
			result.add(columns.clone());
		}
		for (int i = 0; i < 8; i++) {
			if (checkValid(row, i, columns)) {
				columns[row] = i;
				dfs(row + 1, columns, result);
			}
		}
	}

	public boolean checkValid(int row, int i, int[] columns) {
		for (int j = 0; j < row; j++) {
			if (columns[j] == i) {
				return false;
			}
			int rowDis = Math.abs(row - j);
			int colDis = Math.abs(columns[j] - i);
			if (rowDis == colDis) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		EightQueens queen = new EightQueens();
		List<int[]> result = queen.solution();

		for (int[] r : result) {
			for (int i = 0; i < 8; i++) {
				System.out.print(r[i] + " ");
			}
			System.out.println();
		}
	}
}