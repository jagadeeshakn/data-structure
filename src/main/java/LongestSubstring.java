
public class LongestSubstring {

	public static void main(String args[]) {
		String x = "catchthebus";
		String y = "catch";
		findLongSubString(x, y, x.length(), y.length());
	}

	private static void findLongSubString(String x, String y, int m, int n) {
	
		int [][] longestCommonCSuffix= new int[m+1][n+1];
		int l =0;
		int row=0, col=0;
		
		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n; j++) {
				if(i==0 || j==0) {
					longestCommonCSuffix[i][j]=0;
				}else if(x.charAt(i-1) == y.charAt(j-1)) {
					longestCommonCSuffix[i][j] = longestCommonCSuffix[i-1][j-1]+1;
					if(l < longestCommonCSuffix[i][j]) {
						l = longestCommonCSuffix[i][j];
						row = i;
						col = j;
					}
				}else {
					longestCommonCSuffix[i][j] = 0;
				}
			}
		}
		if(l ==0) {
			System.out.println("No substring found");
			return;
		}
		String resultStr = "";
		while(longestCommonCSuffix[row][col]!= 0) {
			resultStr = x.charAt(row -1)+resultStr;
			--l;
			
			row--;
			col--;
		}
		System.out.println(resultStr);
	}
}
