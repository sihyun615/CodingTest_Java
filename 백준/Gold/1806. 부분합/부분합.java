import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());  //수열의 길이
		int S = Integer.parseInt(st.nextToken());  //이상이 돼야하는 합

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 누적 합 배열 생성
		int[] prefixSum = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
		}


		int minLength = Integer.MAX_VALUE;

		// // 모든 가능한 부분합 검사
		// for (int start = 0; start < N; start++) {
		// 	for (int end = start + 1; end <= N; end++) {
		// 		if (prefixSum[end] - prefixSum[start] >= S) {
		// 			minLength = Math.min(minLength, end - start);
		// 		}
		// 	}
		// }

		int start = 0;
		for (int end = 1; end <= N; end++) {
			while (prefixSum[end] - prefixSum[start] >= S) {
				minLength = Math.min(minLength, end - start);
				start++;
			}
		}


		// 결과 출력
		if (minLength == Integer.MAX_VALUE) {
			System.out.println(0);
		} else {
			System.out.println(minLength);
		}
	}

}