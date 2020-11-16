package bitmap;

public class Test {
	public static void main(String[] args) {
		Bitmap bitmap = new Bitmap(1024);
		bitmap.set(880);
		System.out.println(bitmap.get(880));
		System.out.println(bitmap.get(888));
		
	}
}
