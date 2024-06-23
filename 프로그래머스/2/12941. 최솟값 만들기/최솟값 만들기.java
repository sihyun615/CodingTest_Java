import java.util.*;

class Solution
{
    public int solution(int []A, int []B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int len = A.length;
        int minSum = 0;
        
        for (int i = 0; i < len; i++) {
            minSum += A[i] * B[len - 1 - i];
        }
        
        return minSum;
    }
}