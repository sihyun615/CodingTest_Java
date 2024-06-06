import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] height = new int[n];
		for (int i = 0; i < n; i++) {
			height[i] = Integer.parseInt(br.readLine());
		}

		int maxHeight = height[n-1];
		int num = 1;
		for (int i = n-2; i >= 0; i--) {
			if (height[i] > maxHeight) {
				maxHeight = height[i];
				num++;
			}
		}
		System.out.println(num);
	}
}