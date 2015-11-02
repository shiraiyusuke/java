package janken;

/**
 * 「グーが大好き！」戦略クラス
 * @author shirai
 *
 */
public class StoneOnlyTactics implements Tactics{
	/**
	 * 戦略を読み、ジャンケンの手を得る。
	 * グー・チョキ・パーのいずれかをPlayerクラスに定義された以下の定数で返す。
	 * Player.STONE    …グー
	 * Player.SCISSORS …チョキ
	 * Player.PAPER    …パー
	 * @return ジャンケンの手
	 */
	public int readTactics(){
		return Player.STONE;
	}
}
