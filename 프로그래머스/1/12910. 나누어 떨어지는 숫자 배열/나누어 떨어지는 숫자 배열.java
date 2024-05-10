import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer;
        int count = 0;
        for (int num : arr) {
            if (num % divisor == 0) {
                count++;
            }
        }

        if (count == 0) {
            answer = new int[] {-1};
        } 
        else {
            answer = new int[count];
            int index = 0;
            for (int num : arr) {
                if (num % divisor == 0) {
                    answer[index++] = num;
                }
            }
            Arrays.sort(answer);
        }
        return answer;
    }
}
