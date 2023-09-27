package Src;

import java.util.Scanner;

//ユークリッドの互除法によって最大公約数を求める
public class EuclidGCD {
	static int gcd(int x, int y) {
		if (y == 0) {
			return x;
		} else {
			return gcd(y, x % y);
		}
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("2つの整数の最大公約数を求めます。");
		
		System.out.println("整数を入力せよ：");
		int x = stdIn.nextInt();
		System.out.println("整数を入力せよ：");
		int y = stdIn.nextInt();
		
		System.out.println("最大公約数は" + gcd(x, y) + "です。");
	}
}
