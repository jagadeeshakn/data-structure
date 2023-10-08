
public class LongestCommonSubsequence {

	public static void main(String[] args) {

		String x = "ABCDE";
		String y = "BCD";
		int m = x.length();
		int n = y.length();
		int res = findLongestSubSequence(x, y, m, n);
		System.out.println("longest subsequence is "+res);
	}

	private static int findLongestSubSequence(String x, String y, int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}
		if(x.charAt(m-1) == (y.charAt(n-1))) {
			return 1+(findLongestSubSequence(x, y, m-1, n-1));
		}else {
			return max(findLongestSubSequence(x, y, m, n-1),
					findLongestSubSequence(x, y, m-1, n));
		}
	}
	static int max(int a, int b) {
		return (a > b)? a:b;
	}
}
