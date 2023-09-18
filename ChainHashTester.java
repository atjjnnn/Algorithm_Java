package Src;

import java.util.Scanner;

//チェイン法によるハッシュの利用例
public class ChainHashTester {

	static Scanner stdIn = new Scanner(System.in);
	
	//データ（会員番号＋氏名）
	static class Data {
		static final int NO = 1; //番号を読み込むか？
		static final int NAME = 2; //氏名を読み込むか？
		
		private Integer no; //会員番号（キー値）
		private String name; //氏名
		
		//キー値
		Integer keyCode() {
			return no;
		}
		
		//文字列表現を返す
		public String toString() {
			return name;
		}
		
		//データの読み込み
		void scanData(String guide, int sw) {
			System.out.println(guide + "するデータを入力してください。");
			
			if ((sw & NAME) == NO) {
				System.out.println("番号：");
				no = stdIn.nextInt();
			}
			
			if ((sw & NAME) == NAME) {
				System.out.println("氏名：");
				name = stdIn.next();
			}
		}
	}
	
	//メニュー列挙型
	enum Menu {
		ADD(	"追加"),
		REMOVE(	"削除"),
		SEARCH(	"探索"),
		DUMP(	"表示"),
		TERMINATE("終了");
		
		private final String message; //表示用文字列
		
		static Menu MenuAt(int idx) {
			for (Menu m: Menu.values()) //序数がidxである列挙を返す
				if (m.ordinal() == idx)
					return m;
			return null;
		}
		
		Menu(String string) {
			message = string;
		}
		
		String getMessage() {
			return message;
		}
	}
	
	//メニュー選択
	static Menu SelectMenu() {
		int key;
		do {
			for (Menu m: Menu.values())
				System.out.printf("(%d) %s ", m.ordinal(), m.getMessage());
			System.out.println("：");
			key = stdIn.nextInt();
		} while(key < Menu.ADD.ordinal() || key > Menu.TERMINATE.ordinal());
		
		return Menu.MenuAt(key);
	}
	
	public static void main(String[] args) {
		Menu menu;
		Data data;
		Data temp = new Data();
		
		ChainHash<Integer, Data> hash = new ChainHash<Integer, Data>(15);
		
		do {
			switch (menu = SelectMenu()) {
			case ADD:
				data = new Data();
				data.scanData("追加", Data.NO | Data.NAME);
				hash.add(data.keyCode(), data);
				break;
			case REMOVE:
				temp.scanData("削除", Data.NO);
				hash.remove(temp.keyCode());
				break;
			default:
				break;
			}
		} while (menu != Menu.TERMINATE);
	}
	

}
