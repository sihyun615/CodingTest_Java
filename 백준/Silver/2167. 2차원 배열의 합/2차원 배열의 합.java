import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] nums = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] numsPrefixSum = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				numsPrefixSum[i][j] = nums[i][j];
				if (j > 0) {
					numsPrefixSum[i][j] += numsPrefixSum[i][j - 1];
				}
				if (i > 0) {
					numsPrefixSum[i][j] += numsPrefixSum[i - 1][j];
				}
				if (i > 0 && j > 0) {
					numsPrefixSum[i][j] -= numsPrefixSum[i - 1][j - 1];
				}
			}
		}



		int k = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int idx = 0; idx < k; idx++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken()) - 1;
			int j = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;

			int result = numsPrefixSum[x][y];
			if (j > 0) {
				result -= numsPrefixSum[x][j - 1];
			}
			if (i > 0) {
				result -= numsPrefixSum[i - 1][y];
			}
			if (i > 0 && j > 0) {
				result += numsPrefixSum[i - 1][j - 1];
			}

			sb.append(result);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}