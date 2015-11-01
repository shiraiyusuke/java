package janken;

public class Yamada extends Player{
	/**
	 * コンストラクタ
	 * @patam name 名前
	 */
	public Yamada(String name){
		super(name); // スーパークラスのコンストラクタを呼び出す
	}
	
	/**
	 * ジャンケンの手を出す。
	 * @return ジャンケンの手
	 */
	public int showHand(){
		return PAPER;
	}
}
