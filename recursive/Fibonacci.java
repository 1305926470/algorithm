package recursive;


/**
 * 
 * @author xingxing
 * @date 2019-04-21
 */
public class Fibonacci {
	//斐波那契数列
	public static void main(String[] args) {
		for (int i = 0; i < 30; i++) {
			System.out.print(fb(i));
			System.out.print(", ");
		}
	}
	
	
	
	//F(n)=F(n-1)+F(n-2)（n>=3，n∈N*）  如：0、1、1、2、3、5、8、13、21、34、……
	//输入n求F(n)
	public static int fb(int n) {
		if (n < 2) {
			return n;
		}
		return fb(n - 1) + fb(n - 2);
	}
	
	

}
