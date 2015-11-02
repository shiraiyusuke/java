package janken;

/**
 * グー・チョキ・パーを順番に出すクラス
 * @author shirai
 */
public class CyclicTactics implements Tactics{
	int hand = -1;
	
	/**
	 * 戦略を読み、ジャンケンの手を得る。
	 * グー・チョキ・パーのいずれかをPlayerクラスに定義された以下の定数で返す。
	 * Player.STONE    …グー
	 * Player.SCISSORS …チョキ
	 * Player.PAPER    …パー
	 * @return ジャンケンの手
	 */
	public int readTactics(){
		hand ++;
		return hand % 3;
	}
}
