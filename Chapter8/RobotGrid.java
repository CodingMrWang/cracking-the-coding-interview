import java.util.*;

public class RobotGrid {
	List<Point> result = new ArrayList<>();
	boolean flag;
	public List<Point> Solution(boolean[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return null;
		}
		List<Point> path = new ArrayList<>();
		dfs(grid, path, 0, 0);
		return result;
	}
	public void dfs(boolean[][] grid, List<Point> path, int x, int y) {
		if (flag) {
			return;
		}
		if (x == grid.length - 1 && y == grid[0].length - 1) {
			result = new ArrayList<>(path);
			System.out.println("size: " + result.size());
			flag = true;
			return;
		}
		if (inBound(x + 1, y, grid)) {
			grid[x + 1][y] = true;
			path.add(new Point(x + 1, y));
			dfs(grid, path, x + 1, y);
			path.remove(path.size() - 1);
		}
		
		if (inBound(x, y + 1, grid)) {
			grid[x][y + 1] = true;
			path.add(new Point(x, y + 1));
			dfs(grid, path, x, y + 1);
			path.remove(path.size() - 1);
		}
	}
	private boolean inBound(int x, int y, boolean[][] grid) {
		return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && !grid[x][y];
	}
	public static void main(String[] args) {
		boolean[][] grid = new boolean[][]{{false, false, true, false},{true, false, true, true},{false, false, false, false},{true, true, false, false}};
		RobotGrid r = new RobotGrid();
		List<Point> ans = r.Solution(grid);
		for (Point p : ans) {
			System.out.println(p);
		}
	}
}
class Point {
	int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public String toString() {
		return "x: " + this.x + " y: " + this.y;
	}
}