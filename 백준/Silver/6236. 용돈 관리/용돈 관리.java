import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] money = new int[n];


		int min = 0;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			money[i] = Integer.parseInt(br.readLine());
			min = Math.max(min, money[i]);
			sum += money[i];
		}


		int low = min;
		int high = sum;
		int minMoney = 0;

		while (low <= high) {
			int mid = (low+high) / 2;
			int num = 1;
			int total = mid;
			for (int mon : money) {
				if (total < mon) {
					num++;
					total = mid;
				}
				total -= mon;
			}


			if (num > m) {
				low = mid + 1;
			}  else {
				minMoney = mid;
				high = mid - 1;
			}
		}
		System.out.println(minMoney);

	}
}