package Src;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PhysExamSearch {
	
	//身体検査データ
	static class PhyscData {
		private String name; //氏名
		private int height; //身長
		private double vision; //視力
		
		public PhyscData(String name, int height, double vision) {
			this.name = name;
			this.height = height;
			this.vision = vision;
		}
		
		//文字列化
		public String toString() {
			return name + " " + height + " " + vision;
		}
		
		//身長昇順用コンパレーター
		public static final Comparator<PhyscData> HEIGHT_ORDER =
				new HeightOrderComparator();
		
		private static class HeightOrderComparator implements Comparator<PhyscData> {
			public int compare(PhyscData d1, PhyscData d2) {
				return (d1.height > d2.height) ? 1 : (d1.height < d2.height) ? -1 : 0;
			}
		}
	}
	
	public static void main(String[] args) {
		try (Scanner stdIn = new Scanner(System.in)) {
			PhyscData[] x = { //配列の要素は身長順でなければならない
					new PhyscData("永田充輝", 162, 0.3),
					new PhyscData("永田明音", 162, 0.3),
					new PhyscData("永田桧寄", 162, 0.3),
					new PhyscData("永田きなこ", 162, 0.3)
			};
			
			System.out.println("何cmの人を探しますか:");
			int height = stdIn.nextInt();
			int idx = Arrays.binarySearch(
					x, //配列xから
					new PhyscData("", height, 0.0), //身長がheightの要素を
					PhyscData.HEIGHT_ORDER); //HEIGHT_ORDERによって探索
			
			if (idx<0) {
				System.out.println("その値の要素は存在しません");
			} else {
				System.out.println("その値はx[" + idx + "]にあります。");
				System.out.println("データ：" + x[idx]);
			}
		}
	}

}
