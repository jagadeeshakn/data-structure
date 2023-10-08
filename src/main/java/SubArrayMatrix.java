
public class SubArrayMatrix {
	
	public static void main(String args[]) {
		int r = 4, c = 3;
		arrangeMatrix(r, c);
	}

	private static void arrangeMatrix(int r, int c) {
	
		//if column is 1 then return 1 
		if(c == 1) {
			for(int i=1; i<=r; i++) {
				System.out.println(i);
				return;
			}
			//if row is odd then return -1 as valid  arrangement is not possible
		}else if(r % 2 == 1) {
			System.out.println(-1);
			return;
		}else {
			//if row is 
			for(int i=1; i<=r; i++) {

				int k=i;
				//add the row value to the i value
				for(int j=1; j<=c; j++) {
					System.out.print(k+" ");
					k+=r;
				}
				System.out.println();
			}
			return;
		}
	}

}
