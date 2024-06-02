import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());  //입국심사대 수
		int m = Integer.parseInt(st.nextToken());  //사람 수
		int[] time = new int[n];  //입국심사대마다의 심사시간

		for (int i = 0; i < n; i++) {
			time[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(time);

		long low = time[0];
		long high = (long) time[n-1] * m;
		long minTime = 0;

		while (low <= high) {
			long mid = (low+high) / 2;
			long num = 0;  //사람 수
			for (long t : time) {
				num += mid / t;
				if(num >= m) break; // 통과해야되는 인원을 채웠으면 그만 추가하고 탈출
			}


			if (num >= m) {
				minTime = mid;
				high = mid - 1;
			}  else {
				low = mid + 1;
			}
		}
		System.out.println(minTime);

	}
}