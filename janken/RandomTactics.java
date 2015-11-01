package janken;

/**
 * ランダムに手を決める戦略クラス。
 * @author shirai
 * 
 */
public class RandomTactics implements Tactics{
	/**
	 * 戦略を読み、ジャンケンの手を得る。
	 * グー・チョキ・パーのいずれかをPlayerクラスに定義された以下の定数で返す。
	 * Player.STONE    …グー
	 * Player.SCISSORS …チョキ
	 * Player.PAPER    …パー
	 * @return ジャンケンの手
	 */
	public int readTactics(){
			int hand = 0;

			double random = Math.random() * 3;
			if (random < 1){
				hand = Player.STONE;
			}else if(1<= random && random < 2){
				hand = Player.SCISSORS;
			}else{
				hand = Player.PAPER;
			}
			return hand;
	}

}
