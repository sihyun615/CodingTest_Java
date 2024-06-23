class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isFirstChar = true; // 다음 문자가 단어의 첫 글자인지 확인하는 플래그
        
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                isFirstChar = true; // 공백 문자를 만나면 다음 문자가 첫 글자일 수 있음을 설정
            } else {
                if (isFirstChar) {
                    c = Character.toUpperCase(c); // 첫 글자면 대문자로 변환
                    isFirstChar = false; // 다음에 오는 문자는 첫 글자가 아님을 설정
                } else {
                    c = Character.toLowerCase(c); // 첫 글자가 아니면 소문자로 유지
                }
            }
            sb.append(c); // StringBuilder에 문자 추가
        }
        
        return sb.toString();
    }
}