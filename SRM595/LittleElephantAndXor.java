import java.util.Arrays;
import java.util.Scanner;

public class LittleElephantAndXor {

	long[][][][] f = new long[32][2][2][2];
	int[] digOne = new int[32];
	int[] digTwo = new int[32];
	int[] digThree = new int[32];

	public int tran(int state, int digit, int pre) {
		int newState = 0;
		if (pre == 0) {
			newState = 0;
		} else {
			newState = (state == digit ? 1 : 0);
		}
		return newState;
	}

	public long dfs(int len, int stateOne, int stateTwo, int stateThree) {
		if (len == 0) {
			return 1;
		}
		if (f[len][stateOne][stateTwo][stateThree] != -1) {
			return f[len][stateOne][stateTwo][stateThree];
		}
		long res = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				int k = i ^ j;
				if ((stateOne == 0 || digOne[len - 1] >= i)
						&& (stateTwo == 0 || digTwo[len - 1] >= j)
						&& (stateThree == 0 || digThree[len - 1] >= k)) {
					res += dfs(len - 1, tran(i, digOne[len - 1], stateOne),
							tran(j, digTwo[len - 1], stateTwo),
							tran(k, digThree[len - 1], stateThree));
				}
			}
		}
		return f[len][stateOne][stateTwo][stateThree] = res;
	}

	public void work(int num, int[] dig) {
		int cnt = 0;
		while (num > 0) {
			dig[cnt++] = num % 2;
			num /= 2;
		}
	}

	public long getNumber(int A, int B, int C) {
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < 2; k++)
					Arrays.fill(f[i][j][k], -1);
			}
		}
		work(A, digOne);
		work(B, digTwo);
		work(C, digThree);
		return dfs(30, 1, 1, 1);
	}
}
