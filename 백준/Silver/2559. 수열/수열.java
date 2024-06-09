import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());  //합을 구할 연속적인 날짜의 수

		int[] nums = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}


		int[] prefixSum = new int[n];
		prefixSum[0] = nums[0];
		for (int i = 1; i < n; i++) {
				prefixSum[i] = prefixSum[i - 1] + nums[i];
		}


		int maxSum = prefixSum[k - 1];  // 첫번째 구간의 합 (0 ~ k-1)

		for (int i = 1; i < n-k+1; i++) {
			int currentSum = prefixSum[i + k - 1] - prefixSum[i - 1];
			if (currentSum > maxSum) {
				maxSum = currentSum;
			}
		}
		System.out.print(maxSum);
	}
}