class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int countTransform = 0;
        int countZero = 0;
        
        
        while(!s.equals("1")) {
            int removedZero = 0;
            StringBuilder sb = new StringBuilder();
            
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    sb.append('1');
                } else {
                    removedZero++;
                }
            }

            s = Integer.toBinaryString(sb.toString().length());
            
            countZero += removedZero;
            countTransform++;
        }
        
        answer[0] = countTransform;
        answer[1] = countZero;
        return answer;
    }
}