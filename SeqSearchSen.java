package Src;

import java.util.Scanner;

class SeqSearchSen {
	
	static int seqSearchSen(int[] a, int n, int key) {
		int i = 0;
		
		a[n] = key; //番兵を追加
		
		for (int num : a) {
			if (num == key) //探索成功
				break;
			i++;
		}
		return i == n ? -1 : i;
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("要素数:");
		int num = stdIn.nextInt();
		int[] x = new int[num + 1];
		
		for (int i= 0; i< num; i++) {
			System.out.println("x[" + i + "] :");
			x[i] = stdIn.nextInt();
		}
		
		System.out.print("探す値：");
		int ky = stdIn.nextInt();
		
		int idx = seqSearchSen(x, num, ky);
		
		if (idx == -1)
			System.out.println("その値の要素は存在しません。");
		else
			System.out.println("その値はx[" + idx + "]にあります。");
	}
}