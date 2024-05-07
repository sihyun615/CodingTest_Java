class Solution {
    public int solution(int num) {
        return collatz(num, 0);
    }

    private int collatz(long num, int count) {
        if (num == 1) {
            return count;
        }
        if (count >= 500) {
            return -1;
        }
        
        num = (num % 2 == 0) ? num / 2 : num * 3 + 1;
        return collatz(num, count + 1);
    }
}
