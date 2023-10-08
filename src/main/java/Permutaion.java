import java.util.ArrayList;
import java.util.Arrays;

public class Permutaion {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3 };
		ArrayList<int[]> result = permute(a);

		for (int[] r : result) {
			for (int x : r) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}

	// swap the two numbers in a given array
	public static void swap(int[] num, int l, int i) {
		int temp = num[l];
		num[l] = num[i];
		num[i] = temp;
	}

	public static void permutation(ArrayList<int[]> res, int[] num, int l, int h) {
		if (l == h) {
			res.add(Arrays.copyOf(num, num.length));
		}
		for (int i = l; i <= h; i++) {

			swap(num, l, i);

			permutation(res, num, l + 1, h);

			swap(num, l, i);
		}
	}

	static ArrayList<int[]> permute(int[] num) {
		int size = num.length - 1;
		ArrayList<int[]> res = new ArrayList<int[]>();
		permutation(res, num, 0, size);
		return res;
	}
}
