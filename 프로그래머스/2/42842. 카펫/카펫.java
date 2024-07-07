class Solution {
    public int[] solution(int brown, int yellow) {
        int[] ans = new int[2];
        int sum = brown + yellow;
        
        for(int i=3; i<sum ; i++) {
            int y = sum / i;
            
            if (sum % i == 0 && y>=3) {
                int x = i;

                if ((x-2)*(y-2) == yellow) {
                    ans[0] = Math.max(x, y);
                    ans[1] = Math.min(x, y);
                    return ans;
                }
            }
        
        }
        return ans;
    }
}