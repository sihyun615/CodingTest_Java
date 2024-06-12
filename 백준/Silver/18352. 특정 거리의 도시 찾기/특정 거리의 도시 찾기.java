import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
	int idx;
	int cost;

	// 생성자
	Node(int idx, int cost) {
		this.idx = idx;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node other) {
		return Integer.compare(this.cost, other.cost);
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());  //도시 개수
		int M = Integer.parseInt(st.nextToken());  //도로 개수
		int K = Integer.parseInt(st.nextToken());  //최단 거리
		int X = Integer.parseInt(st.nextToken());  //출발도시 번호

		// 인접 리스트 사용
		List<List<Node>> graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		// M개의 도로 정보 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());  //시작 도시
			int B = Integer.parseInt(st.nextToken());  //도착 도시
			graph.get(A).add(new Node(B, 1));  //A도시에서 B도시로 가는 도로 존재 (거리 항상 1)
		}

		// 최단 거리 저장 배열
		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[X] = 0;  // 출발 도시의 거리 초기화

		// 우선순위 큐 사용
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(X, 0));  //출발 도시

		// 방문 여부를 체크할 배열
		boolean[] visited = new boolean[N + 1];


		while (!q.isEmpty()) {
			Node now = q.poll();
			int nowIdx = now.idx;

			if (visited[nowIdx])  //방문했던 노드라면 패스
				continue;
			visited[nowIdx] = true;  //방문했다고 표시

			for (Node neighbor : graph.get(nowIdx)) {
				//
				if (!visited[neighbor.idx] && dist[neighbor.idx] > (dist[nowIdx] + neighbor.cost)) {
					dist[neighbor.idx] = dist[nowIdx] + neighbor.cost;
					q.add(new Node(neighbor.idx, dist[neighbor.idx]));
				}
			}
		}


		boolean check = false;
		for (int i = 1; i <= N; i++) {
			if (dist[i] == K) {  //최단 거리가 K인 모든 도시 출력
				System.out.println(i);
				check = true;
			}
		}
		if (!check) { //최단 거리가 K인 도시가 하나도 존재하지 않으면 -1 출력
			System.out.println(-1);
		}

	}
}