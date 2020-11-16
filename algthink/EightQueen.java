package algthink;

//八皇后问题
public class EightQueen {
	int[] result = new int[8];//下标表示行, 值表示 queen 存储在哪一列
	
	public void cal8queens(int row) {
		if (row == 8) {
			printQueens(result);
			return;
		}
		for (int column = 0; column < 8; ++column) {
			if (isOk(row, column)) {
				result[row] = column;
				cal8queens(row+1); // 考察下一行
			}
		}
	}
	
	
	// 判断 row 行 column 列放置是否合适
	private boolean isOk(int row, int column) {
		int leftup = column - 1, rightup = column + 1;
		for (int i = row-1; i >= 0; --i) { // 逐行往上考察每一行
			if (result[i] == column) return false; // 第 i 行的 column 列有棋子吗？
			if (leftup >= 0) { // 考察左上对角线：第 i 行 leftup 列有棋子吗？
				if (result[i] == leftup) return false;
			}
			if (rightup < 8) { // 考察右上对角线：第 i 行 rightup 列有棋子吗？
				if (result[i] == rightup) return false;
			}
			--leftup; ++rightup;
		}
		return false;
	}











	public void printQueens(int[] result) {
		for (int row = 0; row < 8; ++row) {
			for (int column = 0; column < 8; ++column) {
				if (result[row] == column) 
					System.out.print("Q ");
				else 
					System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
