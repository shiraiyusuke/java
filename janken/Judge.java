package janken;

/**
 * ジャンケンの審判を表すクラス。
 * @author shirai
 */
public class Judge {
	/**
	 * ジャンケンを開始する。
	 * @param player1 判定対象プレイヤー1
	 * @param player2 判定対象プレイヤー2
	 */
	public void startJanken(Player player1, Player player2){
		//ジャンケンの開始を宣言する
		System.out.println("【ジャンケン開始】");
		
		//ジャンケンを3回実行する。
		for(int cnt = 0; cnt < 3; cnt++){
			System.out.println("【" + (cnt + 1) + "回戦目】");
			Player winner = judgeJanken(player1, player2);
			
			if(winner != null){
				System.out.println(winner.getName() + "が勝ちました！");
				winner.notifyResult(true);
			}else{
				System.out.println("引き分けです！");
			}
		}
			
		//　ジャンケンの終了宣言
		System.out.println("【ジャンケン終了】");
		
		Player finalWinner = judgeFinalWinner(player1, player2);
		
		System.out.println(player1.getWinCount() + "対" + player2.getWinCount() + "で");
		
		if (finalWinner != null){
			System.out.println(finalWinner.getName() + "の勝ちです！");
		}else{
			System.out.println("引き分けです！");
		}
	}
	
	/**
	 * プレイヤーの手を見て、勝敗の判定をする。
	 * @param1 プレイヤー1
	 * @param2 プレイヤー2
	 * @return 勝ったプレイヤー。引き分けの場合はnull。
	 */
	private Player judgeJanken(Player player1, Player player2){
		Player winner = null;
		
		int player1hand = player1.showHand(); // player1がジャンケン。
		int player2hand = player2.showHand(); // player2がジャンケン。
		
		printHand(player1hand);
		System.out.println(" vs. ");
		printHand(player2hand);
		
		if(      player1hand == Player.STONE && player2hand == Player.SCISSORS
		      || player1hand == Player.SCISSORS && player2hand == Player.PAPER
		      || player1hand == Player.PAPER && player2hand == Player.STONE){
			winner = player1;
		}else if(player1hand == Player.STONE && player2hand == Player.PAPER
			  || player1hand == Player.SCISSORS && player2hand == Player.STONE
			  || player1hand == Player.PAPER && player2hand == Player.SCISSORS){
			winner = player2;
		}
		return winner;
	}
	
	/**
	 * 最終的な勝者を判定する。
	 * @param player1
	 * @param player2
	 * @return player 勝ったプレイヤー。引き分けなら、null
	 */
	public Player judgeFinalWinner(Player player1, Player player2){
		Player winner = null;
		int player1WindCnt = player1.getWinCount();
		int player2WindCnt = player2.getWinCount();
		if(player1WindCnt > player2WindCnt){
			winner = player1;
		}else if(player1WindCnt < player2WindCnt){
			winner = player2;
		}
		return winner;
	}

	/**
	 * ジャンケンの手を表示する。
	 * @param hand ジャンケンの手
	 */
	private void printHand(int hand){
		switch(hand){
		case Player.STONE :
			System.out.println("グー");
			break;
		case Player.SCISSORS :
			System.out.println("チョキ");
			break;
		case Player.PAPER :
			System.out.println("パー");
			break;
		default :
			break;
		}
	}

}
