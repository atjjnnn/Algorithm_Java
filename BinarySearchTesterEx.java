package Src;

import java.util.Scanner;

public class BinarySearchTesterEx {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("要素数:");
		int num = stdIn.nextInt();
		int[] x = new int[num];
		
		System.out.println("昇順に入力してください");
		
		System.out.println("x[0]:");
		x[0] = stdIn.nextInt();
		
		for (int i=1; i<num; i++) {
			do {
				System.out.println("x[" + i + "]:");
				x[i] = stdIn.nextInt();
			} while (x[i] < x[i - 1]); //一つ前の要素より小さければ再入力
		}
		
		System.out.println("探す値:");
		int ky = stdIn.nextInt();
		
		int idx = Array.binarySearch(x, ky); //配列xから値がkyの要素を探索
		
		if (idx < 0) {
			System.out.println("その値の要素は存在しません。");
		} else {
			System.out.println("その値はx[" + idx + "]にあります。");
		}
	}
}
