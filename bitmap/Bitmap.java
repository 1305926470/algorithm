package bitmap;

//位图
public class Bitmap {
	private int[] bytes;	//申请字符数组，用于存储bitmap数据
	private int nbits;	//总位数
	
	public Bitmap(int nbits) {
		this.nbits = nbits;
		this.bytes = new int[nbits/32+1];
	}
	
	public void set(int n) {
		if (n > nbits)
			return;
		int byteIndex = n/32; 
		int bitIndex = n%32;
		
		//a|=b;即a=a|b;按位或并赋值，按位或有一个为1则为1
		bytes[byteIndex] |= (1 << bitIndex);	//1 << bitIndex 表示1向左为移bitIndex位
	}
	
	public boolean get(int n) {
		if (n > nbits)
			return false;
		int byteIndex = n/32;
		int bitInex = n%32;
		boolean ret = (bytes[byteIndex] & (1 << bitInex)) != 0;
		return ret;		
	}
}
