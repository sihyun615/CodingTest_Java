import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] budget = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			budget[i] = Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());

		Arrays.sort(budget);


		int low = 0;
		int high = budget[n-1];
		int maxMoney = 0;

		while (low <= high) {
			int mid = (low+high) / 2;
			int total = 0;

			for (int b : budget) {
				if (b <= mid) {
					total += b;
				}  else {
					total += mid;
				}
			}

			if (total <= m) {
				maxMoney = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		System.out.println(maxMoney);

	}
}