public class BuildOrder {
	public List<String> buildOrder (String[] projects, String[][] dependencies) {
		Map<String, List<String>> hash = new HashMap<>();
		Map<String, Integer> points = new HashMap<>();
		for (int i = 0; i < projects.length; i++) {
			hash.put(projects[i], new ArrayList<>());
			points.put(projects[i], 0);
		}
		for (int i = 0; i < dependencies.length; i++) {
			hash.put(dependencies[i][0], new ArrayList<>());
			hash.get(dependencies[i][0]).add(dependencies[i][1]);
			points.put(dependencies[i][1], points.get(dependencies[i][1]) + 1);
		}
		List<String> zeroin = getZeroin(projects, points);
		Queue<String> queue = new LinkedList<>();
		for (String s : zeroin) {
			queue.offer(s);
		}
		List<String> result = new ArrayList<>();
		while (!queue.isEmpty()) {
			String temp = queue.poll();
			result.add(temp);
			for (String s : hash.get(temp)) {
				points.put(s, points.get(s) - 1);
			}
			List<String> z = getZeroin(project, points);
			for (String s : z) {
				queue.offer(s);
			}
		}
		if (result.size() == projects.length) {
			return result;
		}
		return null;
	} 

	public List<String> getZeroin(String[] projects, Map<String, Integer> points) {
		List<String> result = new ArrayList<>();
		for (String s : projects) {
			if (points.get(s) == 0) {
				result.add(s);
				points.put(s, -1);
			}
		}
		return result;
	}
}