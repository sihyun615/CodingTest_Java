import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int aIdx = 0;
        int bIdx = 0;
        int score = 0;
        
        for(int i = 0; i < A.length; i++) {
            if (A[aIdx] > B[bIdx]) {
                bIdx++;
            } else if (A[aIdx] < B[bIdx]) {
                aIdx++;
                bIdx++;
                score++;
            } else {  //두 값이 같을 때
                bIdx++;
            }
        }
        return score;
        
    }
}