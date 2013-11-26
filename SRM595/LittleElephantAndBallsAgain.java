public class LittleElephantAndBallsAgain {
	
	public int getNumber(String S) {
		
		int ans = 1, tmp = 1;
		for (int i = 1; i < S.length(); i++) {
			if (S.charAt(i) == S.charAt(i-1)) {
				tmp++;
				ans = Math.max(ans, tmp);
			} else {
				tmp = 1;
			}
		}
		
		return S.length() - ans;
	}

}
