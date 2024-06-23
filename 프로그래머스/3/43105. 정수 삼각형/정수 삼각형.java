class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int [][] sum = new int[n][n];
        sum[0][0] = triangle[0][0];
        
        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                if (j == 0) {
                    sum[i][j] = sum[i-1][j] + triangle[i][j];
                }
                else if (j == i) {
                    sum[i][j] = sum[i-1][j-1] + triangle[i][j];
                }
                else {
                    sum[i][j] = Math.max(sum[i-1][j], sum[i-1][j-1]) + triangle[i][j];
                }
            }
        }
        
        int maxSum = 0;
        for (int j = 0; j < n; j++) {
            maxSum = Math.max(maxSum, sum[n-1][j]);
        }
        
        return maxSum;
    }
}