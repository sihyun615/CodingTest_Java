import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] score = new int[10];

		for (int i = 0; i < 10; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}

		int[] scorePrefixSum = new int[10];
		scorePrefixSum[0] = score[0];
		for (int i = 1; i < 10; i++) {
			scorePrefixSum[i] = scorePrefixSum[i-1] + score[i];
		}

		int prev = Math.abs(scorePrefixSum[9] - 100);
		int answerIdx = 0;
		for (int i = 0; i < 10; i++) {
			if (Math.abs(scorePrefixSum[i]-100) <= prev) {
				prev = Math.abs(scorePrefixSum[i]-100);
				answerIdx = i;
			}
		}
		System.out.println(scorePrefixSum[answerIdx]);

	}
}