package search;

public class Test {
	public static void main(String[] args) {
//		Sk skipList = new Sk();
		SkipList skipList = new SkipList();
		
		skipList.insert(12);
		skipList.insert(13);
		skipList.insert(21);
		skipList.insert(413);
		skipList.insert(0);
		skipList.insert(2);
		skipList.insert(3);
		skipList.insert(11);
		skipList.insert(12);
		
		skipList.printAll();
		System.out.println();
//		skipList.find(12);
		
		skipList.delete(2);
		skipList.delete(11);
		skipList.delete(12);
		skipList.delete(12);
		skipList.printAll();
		
		
//		System.out.println(skipList.find(12));
	}
}
