class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int si = 0;	// 기지국 인덱스
        int position = 1;

        while(position <= n) {
            //기존 설치 기지국 전파 범위 내
            if(si < stations.length && position >= stations[si] - w) {
                position = stations[si] + w + 1;  // 기지국의 범위 바로 다음 위치로 이동
                si++;	// 다음 설치한 기지국
            } else { //기존 설치 기지국 전파 범위 내에 없으면
                answer += 1;  //현재 자리에 새로운 기지국 설치

                //현재 설치 기지국의 범위 바로 다음 위치로 이동
                position += (w*2) + 1;
            }
        }
        return answer;
    }
}