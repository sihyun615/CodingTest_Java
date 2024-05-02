class Solution {
    public long solution(long n) {
        String answer = Long.toString(n); //long을 string으로 변환
        char[] chars = answer.toCharArray(); //string을 char배열로 변환(자리바꾸기위해)
        char temp;
        for (int i=0; i<chars.length-1; i++){
            for (int j=i+1; j<chars.length; j++){
                if(chars[i] < chars[j]){
                    temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                
                }
            }
        }
        
        answer = String.valueOf(chars);  //완료한 char배열을 answer문자열로 저장
        

        return Long.parseLong(answer); //문자열을 long형태로 리턴
    }
}