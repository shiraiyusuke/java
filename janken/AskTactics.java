package janken;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 標準出力でジャンケンの手をユーザーに聞くクラス
 * @author shirai
 */
public class AskTactics implements Tactics{
	/**
	 * 戦略を読み、ジャンケンの手を得る。
	 * グー・チョキ・パーのいずれかをPlayerクラスに定義された以下の定数で返す。
	 * Player.STONE    …グー
	 * Player.SCISSORS …チョキ
	 * Player.PAPER    …パー
	 * @return ジャンケンの手
	 */
	public int readTactics(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("ジャンケンの手を入力してください。");
		System.out.println("0:グー、1:チョキ、2:パー:");
		int hand = 0;
		
		while(true){
			try{
				String inputStr = br.readLine();
				hand = Integer.parseInt(inputStr);
				if(hand == Player.STONE || hand == Player.SCISSORS || hand == Player.PAPER){
					break;
				} else {
					System.out.println("入力がおかしいです。再度入力してください");
				}
			}catch(Exception ex){
				System.out.println("入力が正しくありません。再度入力してください。");
				System.out.println("? ");
			}
		}
		return hand;
	}
}
