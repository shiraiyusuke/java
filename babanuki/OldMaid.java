package babanuki;

/**
 * ババ抜きプログラム
 * @author shirai
 *
 */
public class OldMaid {
	public static void main(String[] args) {
		//進行役の生成
		Master master = new Master();
		
		//テーブルの生成
		Table field = new Table();
		
		//プレイヤーの生成
		Player murata = new Player("村田", master, field);
		Player yamada = new Player("山田", master, field);
		Player saito  = new Player("斎藤", master, field);
		
		//進行役にプレイヤーを登録
		master.registerPlayer(murata);
		master.registerPlayer(yamada);
		master.registerPlayer(saito);
		
		//トランプの生成
		Hand trump = createTrump();
		
		//ゲームの準備
		master.prepareGame(trump);
		
		//ゲームを開始する
		master.startGame();
	}
	
	private static Hand createTrump(){
		Hand trump = new Hand();
		
		//角スート13枚ずつ＋ジョーカーの53枚を生成
		for(int number = 1; number <= 13; number++){
			trump.addCard(new Card(Card.SUIT_CLUB, number));
			trump.addCard(new Card(Card.SUIT_DIAMOND, number));
			trump.addCard(new Card(Card.SUIT_HEART, number));
			trump.addCard(new Card(Card.SUIT_SPADE, number));
		}
		
		trump.addCard(new Card(0, Card.JOKER));
		
		return trump;
	}
}
