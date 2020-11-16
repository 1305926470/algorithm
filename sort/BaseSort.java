package sort;

public class BaseSort {
	public static void printAll(int[] argv) {
		for (int i = 0; i < argv.length; i++) {
			System.out.print(argv[i]);
			System.out.print(", ");
		}
		System.out.println();
	}
}
