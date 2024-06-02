import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] size = new int[k];

		int max = 0;
		for (int i = 0; i < k; i++) {
			size[i] = Integer.parseInt(br.readLine());
			if (size[i] > max) {
				max = size[i];
			}
		}


		long low = 1;
		long high = max;
		long maxLength = 0;

		while (low <= high) {
			long mid = (low+high) / 2;
			long num = 0;
			for (int s : size) {
				num += s/mid;
			}


			if (num >= n) {
				maxLength = mid;
				low = mid + 1;
			}  else {
				high = mid - 1;
			}
		}
		System.out.println(maxLength);

	}
}