class Solution {
    public int solution(String s) {
        
        int sign = 1;  //부호의 기본값을 양수로 설정
        switch (s.charAt(0)) {
            case '+' : 
                //substring(idx) : idx 위치부터 문자열의 끝까지 추출
                s = s.substring(1);  //부호 제거 (0번째가 아닌 1번째이므로 부호 생략됨)
                break;
            
            case '-' : 
                sign = -1;  //부호를 -1로 설정
                //substring(idx) : idx 위치부터 문자열의 끝까지 추출
                s = s.substring(1);  //부호 제거 (0번째가 아닌 1번째이므로 부호 생략됨)
                break;
            
            default :  //문자열이 부호로 시작하지 않는 경우
                break;
        }

        
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);  //앞에서부터
            int digit = c - '0';  //문자를 숫자로 변환
            answer = answer * 10 + digit;  //계속해서 일의 자리에 추가
        }
        
        return sign * answer;  //변환한 정수에 부호 붙이기
        
    }
}