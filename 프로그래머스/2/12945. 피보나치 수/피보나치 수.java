class Solution {
    static int[] data = new int[100001]; // 최대값 100000
    
    public int solution(int n) {
        return fibo(n);
    }
    
    public int fibo(int n) {
        if(n < 2) return n;  // 0과 1은 그대로 return
        if(data[n] != 0) return data[n] % 1234567;  // n번째 피보나치 수 / 1234567 값 return
        return data[n] = (fibo(n - 1) + fibo(n - 2)) % 1234567;
    }
}