class Solution {
    public int solution(int n) {
        int answer = 0;
        
        if (n%2==1){
            answer = 2;
        }
        
        else {
            for(int i=2; i< n; i++){
                if(n%i == 1){
                    answer = i;
                    break;
                }
            }  
        }
        
        return answer;
    }
}