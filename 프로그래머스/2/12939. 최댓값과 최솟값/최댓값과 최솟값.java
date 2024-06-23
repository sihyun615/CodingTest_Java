class Solution {
    public String solution(String s) {
        String[] numbers = s.split(" ");
        
        int min = Integer.parseInt(numbers[0]);
        int max = Integer.parseInt(numbers[0]);
        
        for (String num : numbers) {
            int number = Integer.parseInt(num);
            if (number < min) {
                min = number;
            }
            if (number > max) {
                max = number;
            }
        }
        
        return min + " " + max;
    }
}