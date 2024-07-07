import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        // int[] out = new int[routes.length];
        // for(int i=0; i<routes.length; i++) {
        //     out[i] = routes[i][1];
        // }
        // Arrays.sort(out);
        
        Arrays.sort(routes, (o1, o2) -> {
            return o1[1] - o2[1];
        });

        int cam = 1;
        int end = routes[0][1];
        for(int i=1; i<routes.length; i++) {
            if (routes[i][0] > end) {  //이전 설치 카메라 범위 밖
                end = routes[i][1];
                cam++;  //카메라 설치
            }
        }
        return cam;
    }
}