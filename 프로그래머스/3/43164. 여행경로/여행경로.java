import java.util.*;

class Solution {
    boolean[] visited;
	List<String> answer = new ArrayList<>();
	public String[] solution(String[][] tickets) {
		visited = new boolean[tickets.length];
		dfs("ICN", "ICN", tickets, 0);
		answer.sort(Comparator.naturalOrder());
		return answer.get(0).split(" ");
	}
	void dfs(String cur, String route, String[][] tickets, int count) {
		if (count == tickets.length) {
			answer.add(route);
			return;
		}
		for (int i = 0; i < tickets.length; i++) {
			if (!visited[i] && cur.equals(tickets[i][0])) {
				visited[i] = true;
				dfs(tickets[i][1], route + " " + tickets[i][1], tickets, count + 1);
				visited[i] = false;
			}
		}
	}
}