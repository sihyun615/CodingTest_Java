class Solution {
    public int solution(int n) {
        int countOnes = Integer.bitCount(n); // 입력된 숫자의 1의 개수 세기
        int nextNumber = n + 1; // 입력된 숫자보다 큰 숫자부터 시작

        while (true) {
            if (Integer.bitCount(nextNumber) == countOnes) { // 1의 개수가 동일한지 확인
                return nextNumber;
            }
            nextNumber++; // 다음 숫자로 이동
        }
    }
}