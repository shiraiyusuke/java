package janken;

public class Murata extends Player{
	/**
	 * コンストラクタ
	 * @patam name 名前
	 */
	public Murata(String name){
		super(name); // スーパークラスのコンストラクタを呼び出す
	}
	
	/**
	 * ジャンケンの手を出す。
	 * @return ジャンケンの手
	 */
	public int showHand(){
		return STONE;
	}
}