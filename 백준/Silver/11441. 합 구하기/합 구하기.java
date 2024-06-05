import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int[n];

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}


		int[] numsPrefixSum = new int[n];
		numsPrefixSum[0] = nums[0];
		for (int i = 1; i < n; i++) {
			numsPrefixSum[i] = numsPrefixSum[i-1] + nums[i];
		}



		int m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int k = 0; k < m; k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());

			if (i == 1) {
				sb.append(numsPrefixSum[j-1]);
				sb.append("\n");
			} else {
				sb.append(numsPrefixSum[j-1] - numsPrefixSum[i-2]);
				sb.append("\n");
			}

		}
		System.out.println(sb);

	}
}