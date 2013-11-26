package SRM595;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class LittleElephantAndIntervalsDiv1 {

	public long getNumber(int M, int[] L, int[] R) {

		int[] idx = new int[M];
		Arrays.fill(idx, -1);

		for (int i = 0; i < L.length; i++) {
			for (int j = L[i] - 1; j < R[i]; j++) {
				idx[j] = i;
			}
		}

		HashSet<Integer> hash = new HashSet();
		for (int i : idx) {
			if (i != -1)
				hash.add(i);
		}
		return ((long)1 << hash.size());
	}
	
	Scanner scan = new Scanner(System.in);
	
	public void run() {
		int M = scan.nextInt();
		int n = scan.nextInt();
		int[] L = new int[n];
		int[] R = new int[n];
		for (int i = 0; i < n; i++)
			L[i] = scan.nextInt();
		for (int i = 0; i < n; i++)
			R[i] = scan.nextInt();
		System.out.println(getNumber(M, L, R));
	}

	public static void main(String args[]) {
		new LittleElephantAndIntervalsDiv1().run();
	}
	
}

