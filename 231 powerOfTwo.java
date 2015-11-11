//power of two

/*Given an integer, write a function to determine if it is a power of two.*/
//8 = 1000 7 = 0111 8&7 = 0
//4 = 100 3 = 011 4&3 = 0
//2 = 10; 1 = 01
//1 = 1; 0 = 0


public class Solution{
	public boolean isPowerOfTwo(int n)
	{
		//method1
		return n > 0 && Integer.bitCount(n) == 1;
		//method2
		return n > 0 && n & (n-1) == 0
	}
}
