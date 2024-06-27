class Solution {
    public int[] solution(int n, int s) {
        if (s < n) {
            return new int[] {-1};
        }
        
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = s / n;
        }
        
        int r = s % n;
        for(int i = 0; i < r; i++) {
            result[n-i-1]++;
        }
        return result;
    }
}