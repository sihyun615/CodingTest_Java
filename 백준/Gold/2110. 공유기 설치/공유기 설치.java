import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] home = new int[n];

		for (int i = 0; i < n; i++) {
			home[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(home);

		int low = 1;
		int high = home[n-1] - home[0];
		int maxLength = 0;

		while (low <= high) {
			int mid = (low+high) / 2;
			int num = 1;  //거리를 최대화하기 위해 첫집에 공유기 설치할 것!
			int installed = home[0];
			for (int i=1; i<n; i++){
				int total = home[i] - installed;
				if (total >= mid) {
					num++;
					installed = home[i];
				}
			}


			if (num >= c) {
				maxLength = mid;
				low = mid + 1;
			}  else {
				high = mid - 1;
			}
		}
		System.out.println(maxLength);

	}
}