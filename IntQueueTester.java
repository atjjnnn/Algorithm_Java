package Src;

import java.util.Scanner;

public class IntQueueTester {
	
	public static void main(String[] args) {
		try (Scanner stdIn = new Scanner(System.in)) {
			IntQueue s = new IntQueue(64);
			
			while(true) {
				System.out.printf("現在のデータ数：%d / %d¥n", s.size(), s.getCapacity());
				System.out.print("(1)エンキュー (2)デキュー (3)ピーク (4)ダンプ (0)終了：");
				
				int menu = stdIn.nextInt();
				if (menu == 0) break;
				
				int x;
				switch(menu) {
				case 1:
					System.out.println("データ：");
					x = stdIn.nextInt();
					try {
						x = s.enque(x);
					} catch (IntQueue.OverflowIntQueueException e) {
						System.out.println("データが満杯です");
					}
					break;
				case 2:
					try {
						x = s.deque();
						System.out.println("でキューしたデータは" + x + "です。");
					} catch (IntQueue.EmptyIntQueueException e) {
						System.out.println("キューが空です。");
					}
					break;
				case 3:
					try {
						x = s.peek();
						System.out.println("ピークしたデータは" + x + "です。");
					} catch (IntQueue.EmptyIntQueueException e) {
						System.out.println("キューが空です。");
					}
					break;
				case 4:
					s.dump();
					break;
				default:
					break;
				}
			}
		}
	}
}
