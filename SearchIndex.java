package Src;

import java.util.Scanner;

public class SearchIndex {
	
	static int searchIndex(int[] a, int n, int key, int[] idx) {
		
		 int index_of_idx = 0;
		
		for (int i=0; i<n; i++) {
			if (a[i] == key) {
				idx[index_of_idx++] = i;
			}
		}
		return index_of_idx;
	}
	
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("要素数");
			
			int num = sc.nextInt();
			
			int[] x = new int[num];
			int[] y = new int[num];
			
			for (int i=0; i<num; i++) {
				System.out.println("x[" + i + "] :");
				x[i] = sc.nextInt();
			}
			
			System.out.println("探す値:");
			int ky = sc.nextInt();
			
			int count = searchIndex(x, num, ky, y);
			
			if (count == 0) {
				System.out.println("その値の要素は存在しません");
			} else {
				for (int i=0; i<count; i++)
					System.out.println("その値は" + "x[" + y[i] + "]にあります");
			}
		}
	}
}
