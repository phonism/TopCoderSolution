public class ORSolitaire {
	public int getMinimum(int[] numbers, int goal) {
		int result = numbers.length;
		for (int i = 0; i < 31; i++) {
			if ((goal & (1 << i)) > 0) {
				int cnt = 0;
				for (int x : numbers) {
					if (((x & (1 << i)) > 0) && ((x & goal) == x)) {
						cnt++;
					}
				}
				result = Math.min(result, cnt);
			}
		}
		return result;
	}

	public static void main(String args[]) {
		int[] numbers = new int[3];
		numbers[0] = 2;
		numbers[1] = 7;
		numbers[2] = 5;
		int goal = 7;
		System.out.println(new ORSolitaire().getMinimum(numbers, goal));
	}
}

