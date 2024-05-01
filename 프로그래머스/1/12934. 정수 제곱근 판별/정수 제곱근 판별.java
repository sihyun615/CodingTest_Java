class Solution {
    public long solution(long n) {
        long x;
        long answer = -1;
        
        for(x=1; x*x <= n; x++){
            if(x*x == n){
                answer = (x+1)*(x+1);
            }
        }

        return answer;
    }
}