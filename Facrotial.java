package Src;

import java.util.Scanner;

public class Facrotial {
	//非負の整数値nの階乗値を返却
	//10の階乗値である10!は、10*9!で求められ、9!は、9*8!で求められる
	static int factorial(int n) {
		if (n > 0) {
			return n * factorial(n - 1);
		} else {
			return 1;
		}
	}
		
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("整数を入力せよ");
		int x = stdIn.nextInt();
		
		System.out.println(x + "の階乗値は" + factorial(x) + "です。");
		
	}
}
