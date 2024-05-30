import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 칭호의 갯수 3
		int m = Integer.parseInt(st.nextToken()); // 출력해야 하는 캐릭터들의 개수 8
		StringBuilder sb = new StringBuilder();


		String[] name = new String[n];
		int[] power = new int[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			name[i] = st.nextToken();
			power[i] = Integer.parseInt(st.nextToken());
		}



		for (int i = 0; i < m; i++) {
			int low = 0;
			int high = power.length - 1;

			int num = Integer.parseInt(br.readLine());
			while (low <= high) {
				int mid = (low + high) / 2;
				if (power[mid] < num) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
			sb.append(name[high+1]);
			sb.append("\n");
		}

		System.out.println(sb);

	}
}