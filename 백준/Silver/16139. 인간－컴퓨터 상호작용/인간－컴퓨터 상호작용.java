import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String S = br.readLine();  //문자열
		int q = Integer.parseInt(br.readLine());  //질문의 수

		int n = S.length();  // 문자열의 길이

		// 각 문자의 누적합을 저장할 2차원 배열
		int[][] prefixSum = new int[26][n + 1];

		// 누적합 계산
		for (int i = 0; i < n; i++) {
			int charIndex = S.charAt(i) - 'a';  // 문자를 인덱스로 변환
			for (int j = 0; j < 26; j++) {
				prefixSum[j][i + 1] = prefixSum[j][i] + (j == charIndex ? 1 : 0);
			}
		}


		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());

			char alpha = st.nextToken().charAt(0);
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			int charIndex = alpha - 'a';  // 문자를 인덱스로 변환
			// 해당 문자의 누적합 배열에서 범위 내 등장 횟수 계산
			int count = prefixSum[charIndex][r + 1] - prefixSum[charIndex][l];

			sb.append(count).append("\n");  // 결과 저장
		}

		System.out.print(sb);
	}
}