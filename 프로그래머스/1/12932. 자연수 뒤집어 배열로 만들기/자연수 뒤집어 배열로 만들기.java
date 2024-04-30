class Solution {
    public int[] solution(long n) {
        
        long a = n;
        int length = 0;
        while (a>=1){
            length++;
            a /= 10;
        }
        
        
        int[] answer = new int[length];
        
        for (int i = 0; i < length; i++) {
            answer[i] = (int) (n % 10);
            n /= 10;
        }
        
        return answer;
    
    }
}