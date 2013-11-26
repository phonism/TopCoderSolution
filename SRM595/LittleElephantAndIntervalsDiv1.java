import java.util.Arrays;
import java.util.HashSet;

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
	
}

