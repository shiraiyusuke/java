package janken;

/**
 * 戦略インタフェースに対応したオブジェクト指向によるジャンケンプログラム。
 * @author shirai
 */
public class ObjectJanken {
	public static void main(String[] args) {
		Judge saito = new Judge();
		
		Player murata = new Player("村田さん");
		Tactics murataTactics = new AskTactics();
		murata.setTactics(murataTactics);
		
		Player yamada = new Player("山田さん");
		Tactics yamadaTactics = new CyclicTactics();
		yamada.setTactics(yamadaTactics);
		
		saito.startJanken(murata, yamada);
	}
}
