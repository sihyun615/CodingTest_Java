import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] value = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			value[i] = Integer.parseInt(st.nextToken());
		}

		int lowValue = 0;
		int highValue = 0;
		long prevSum = Long.MAX_VALUE;

		for (int i = 0; i < n-1; i++) {
			int low = i + 1;
			int high = n - 1;

			while (low <= high) {
				int mid = (low + high) / 2;
				long sum = value[i] + value[mid];

				if (Math.abs(sum) < prevSum) {
					lowValue = value[i];
					highValue = value[mid];
					prevSum = Math.abs(sum);
				}

				if (sum < 0) {
					low = mid + 1;
				} else {
					high = mid - 1;
				} 
			}
		}

		System.out.println(lowValue + " " + highValue);
	}
}