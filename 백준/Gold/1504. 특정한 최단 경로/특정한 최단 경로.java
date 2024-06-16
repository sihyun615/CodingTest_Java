import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
	int idx;
	long cost;

	// 생성자
	Node(int idx, long cost) {
		this.idx = idx;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node other) {
		return Long.compare(this.cost, other.cost);
	}
}

public class Main {
	static final long INF = 200000000L;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());


		// 인접 리스트 사용
		List<List<Node>> graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());  //삽입
		}


		// N개의 경로 입력
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());  //시작
			int y = Integer.parseInt(st.nextToken());  //도착
			int length = Integer.parseInt(st.nextToken());  //길이(가중치)

			graph.get(x).add(new Node(y, length));  // x에서 y로 가는 간선
			graph.get(y).add(new Node(x, length));  // y에서 x로 가는 간선 (양방향)

		}

		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());


		long[] dist1 = dijkstra(graph, N, 1);  //1로부터 각 노드까지의 최소 거리
		long[] distV1 = dijkstra(graph, N, v1);  //v1로부터 각 노드까지의 최소 거리
		long[] distV2 = dijkstra(graph, N, v2);  //v2로부터 각 노드까지의 최소 거리

		long route1 = dist1[v1] + distV1[v2] + distV2[N];  //1 -> v1 -> v2 -> N
		long route2 = dist1[v2] + distV2[v1] + distV1[N];  //1 -> v2 -> v1 -> N
		

		long result = Math.min(route1, route2);


		if (result >= INF) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}

	}


	static long[] dijkstra(List<List<Node>> graph, int N, int start) {
		// 최단 거리 저장 배열
		long[] dist = new long[N+1];
		Arrays.fill(dist, INF);
		dist[start] = 0;  // 출발지의 거리 초기화

		// 우선순위 큐 사용
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(start, 0));  //출발지 정점과 가중치를 우선순위 큐에 넣음

		// // 방문 여부를 체크할 배열
		// boolean[] visited = new boolean[N + 1];


		while (!q.isEmpty()) {  //큐에 값이 하나도 없을때까지 반복
			Node now = q.poll();  //큐에서 앞에 있는 노드 반환 및 삭제 (현재 큐에 있는 값 중 출발지로부터 가장 가까운 거리)
			int nowIdx = now.idx;

			// if (visited[nowIdx])  //방문했던 노드라면 패스
			// 	continue;
			// visited[nowIdx] = true;  //방문했다고 표시

			// 꺼낸 노드 = 현재 최소 비용을 갖는 노드.
			// 즉, 해당 노드의 비용이 현재 dist배열에 기록된 내용보다 크다면 고려할 필요가 없으므로 스킵한다.
			if (dist[nowIdx] < now.cost) { //해당 노드에 대한 distance값은 여러번 갱신될 수 있어서 큐에 자주 들어갈 수있지만, 한번 방문됐다면 distance의 값은 최소값이다.
				continue;//distance의 값이 더 작으니까 볼 필요없다 -> 이미 방문된 노드이다.
			}// 값이 같은 순간 => distance값이 갱신되서 큐에 들어갔고, 우선순위상 해당 노드가 지금 뽑혔다.
			// distance값이 더 큰 경우가 생기는 이유 => 시작노드에서는 인접노드를 모두 큐에 넣게 되며 거리값을 갱신한다. 그 이후 다른값으로 갱신되더라도, 시작노드때 큐에 넣어놓은 값은 남아있기 때문이다.
			// 그런값을 무시하기 위해 위와같은 조건문을 붙인다.

			for (Node neighbor : graph.get(nowIdx)) {
				if (dist[neighbor.idx] > (dist[nowIdx] + neighbor.cost)) {
					dist[neighbor.idx] = dist[nowIdx] + neighbor.cost;
					q.add(new Node(neighbor.idx, dist[neighbor.idx]));
				}
			}
		}
		return dist;

	}
}