import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minPq = new PriorityQueue<>(); 
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String operation : operations) {
            String[] values = operation.split(" ");
            String op = values[0];
            int num = Integer.parseInt(values[1]);

            if (op.equals("I")) {
                minPq.add(num);
                maxPq.add(num);
            } else if (op.equals("D")) {
                if (minPq.isEmpty()) {
                    continue;
                }
                
                if (num == 1) {
                    int maxValue = maxPq.poll();
                    minPq.remove(maxValue);
                } else if (num == -1) {
                    int minValue = minPq.poll();
                    maxPq.remove(minValue);
                }       
            }
        }
        
        if (minPq.isEmpty()) {
            return new int[] {0, 0};
        } else {
            return new int[]{maxPq.peek(), minPq.peek()};
        }

    }
}