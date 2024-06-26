import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> maxPq = new PriorityQueue<>((a, b) -> b - a);
        for (int w : works) {
            maxPq.add(w);
        }
        
        
        while (n > 0 && !maxPq.isEmpty()) {
            int maxValue = maxPq.poll();
            
            if (maxValue > 0) {
                maxPq.add(maxValue - 1);
            }
            n--;
        }
        
        long result = 0;
        while (!maxPq.isEmpty()) {
            int work = maxPq.poll();
            result +=  work * work;
        }
        
        return result;
    }
}



// class Solution {
//     public long solution(int n, int[] works) {
//         long result = 0;
        
//         while (n > 0) {
//             int maxIdx = -1;
//             int maxValue = -1;
            
//             for (int i = 0; i < works.length; i++) {
//                 if (works[i] > maxValue) {
//                     maxValue = works[i];
//                     maxIdx = i;
//                 }
//             }
            
//             if (maxValue == 0) {
//                 break;
//             }

//             works[maxIdx]--;
//             n--;
//         }
        
//         for(int w : works) {
//             result += w * w;
//         }
//         return result;

//     }
// }