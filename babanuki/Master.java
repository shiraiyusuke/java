package babanuki;

import java.util.ArrayList;

public class Master {
	private ArrayList players_ = new ArrayList();
	
	/**
	 * ゲームの準備をする。
	 * @param cards トランプを進行役の手札として渡す
	 */
	public void prepareGame(Hand cards){
		System.out.println("【カードを配ります】");
		
		cards.shuffle();
		
		int numberOfCards = cards.getNumberOfCards();
		int numberOfPlayers = players_.size();
		
		for(int index = 0; index < numberOfCards; index++){
			Card card = cards.pickCard();
			
			Player player = (Player) players_.get(index % numberOfPlayers);
			player.receiveCard(card);
		}
	}
	
	/**
	 * ゲームを開始する
	 */
	public void startGame(){
		System.out.println("【ばばぬきを始めます。】");
		
		for(int count = 0; players_.size() > 0; count++){
			int playerIndex = count % players_.size();
			int nextPlayerIndex = (count + 1) % players_.size();
			
			//指名するプレイヤーの取得
			Player player = (Player) players_.get(playerIndex);
			
			//次のプレイヤーの取得
			Player nextPlayer = (Player) players_.get(nextPlayerIndex);
			
			System.out.println(player + "さんの番です");
			player.play(nextPlayer);
		}
		
		System.out.println("【ばば抜きを終了しました。】");
	}
	
	/**
	 * 上がり宣言をする
	 * @param winner 上がったプレイヤー
	 */
	public void declareWin(Player winner){
		System.out.println(winner + "さんが上がりました！");
		players_.remove(players_.indexOf(winner));
		
		if(players_.size() == 1){
			Player loser = (Player) players_.get(0);
			System.out.println(loser + "さんの負けです！");
		}
	}
	
	public void registerPlayer(Player player){
		players_.add(player);
	}
}
