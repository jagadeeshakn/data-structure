
public class WeightArray {

	public static void main(String args[]) {
		int a[] = {0,-1,2,3,1,-2};
		int x = -2;
		boolean result = findWeight(a,x);
		System.out.println("weight of the array is available is "+result);
	}

	private static boolean findWeight(int[] a, int x) {
		
		for(int i=0; i<(a.length-1); i++) {
			for(int j=(i+1); j<a.length; j++) {
				if(a[i]+a[j]== x) {
					return true;
				}
			}
		}
		return false;
	}
}
