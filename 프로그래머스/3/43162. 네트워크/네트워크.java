class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n]; // 방문여부 확인 배열
        int networkCount = 0; // 네트워크 개수
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) { // 아직 방문하지 않은 컴퓨터를 찾으면
                dfs(i, computers, visited); // DFS 탐색 시작
                networkCount++; // 새로운 네트워크 발견
            }
        }
        
        return networkCount;
    }
    
    
    private void dfs(int node, int[][] computers, boolean[] visited) {
        visited[node] = true; // 현재 노드를 방문 처리
        
        for (int i = 0; i < computers.length; i++) {
            if (computers[node][i] == 1 && !visited[i]) { // 연결되어 있고 방문하지 않은 노드 탐색
                dfs(i, computers, visited); // 재귀적으로 DFS 탐색
            }
        }
    }
    
}