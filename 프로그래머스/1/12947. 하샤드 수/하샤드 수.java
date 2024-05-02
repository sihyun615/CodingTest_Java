class Solution {
    public boolean solution(int x) {
        boolean answer = false;
        int copyX = x;
        int result = 0;
        
        while (copyX > 0){
            result += copyX % 10;
            copyX /= 10;
        }
        
      
        if(x%result == 0){
            answer = true;
        }
        
        
        return answer;
    }
}