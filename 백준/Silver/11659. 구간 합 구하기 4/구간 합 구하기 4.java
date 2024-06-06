import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] nums = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int[] prefixSum = new int[n];
		prefixSum[0] = nums[0];
		for (int i = 1; i < n; i++) {
			prefixSum[i] = prefixSum[i-1] + nums[i];
		}


		for (int k = 0; k < m; k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken()) - 1;
			int j = Integer.parseInt(st.nextToken()) - 1;

			if (i == 0) {
				sb.append(prefixSum[j]).append("\n");
			} else {
				sb.append(prefixSum[j] - prefixSum[i-1]).append("\n");
			}

		}

		System.out.println(sb);
	}
}