class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        int cnt = 0;
        int[][] region = new int[n+1][m+1];
        
        // 물에 잠긴 지역 표시
        for (int[] puddle : puddles) {
            region[puddle[1]][puddle[0]] = -1;
        }
        
        region[1][1] = 1;
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if (region[i][j] == -1) {  // 물에 잠긴 지역
                    region[i][j] = 0;
                    continue;
                }

                if (i > 1) region[i][j] = (region[i][j] + region[i - 1][j]) % 1000000007;
                if (j > 1) region[i][j] = (region[i][j] + region[i][j - 1]) % 1000000007;

            }
        }
        return region[n][m];
    }
}