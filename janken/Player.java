package janken;

/**
 * 
 * @author shirai
 * ジャンケンのプレイヤーを表すクラス。
 */
public class Player {
	//定数
	public static final int STONE = 1;    //グー
	public static final int SCISSORS = 2; //チョキ
	public static final int PAPER = 3;    //パー

	//--------------------
	//プレイヤークラスの属性
	//--------------------
	/** プレイヤーの名前 */
	private String name_;
	
	/** プレイヤーの勝った回数 */
	private int winCount_ = 0;
	
	/** 与えられる戦略 */
	private Tactics tactics_;
	
	/**
	 * プレイヤークラスのコンストラクタ
	 * @param name 名前
	 */
	public Player(String name){
		this.name_ = name;
	}
	
	//--------------------
	// プレイヤークラスの操作
	//--------------------
	/**
	 * ジャンケンの手を出す。
	 * @return ジャンケンの手
	 */
	int showHand(){
		int hand = tactics_.readTactics();
		return hand;
	}
	
	/* interfaceの利用前の関数
	public int showHand(){
		double random = 0.0;
		int hand = 0;

		random = Math.random() * 3;
		if (random < 1){
			hand = STONE;
		}else if(1<= random && random < 2){
			hand = SCISSORS;
		}else{
			hand = PAPER;
		}
		return hand;
	}
	/*
	
	/**
	 *  審判から勝敗を聞く。
	 *  @param result true:勝ち、false:負け
	 */
	public void notifyResult(boolean result){
		if(result == true){
			winCount_ ++;
		}
	}
	
	/**
	 * 自分の勝った回数を数える。
	 * @return 勝った回数
	 */
	public int getWinCount(){
		return winCount_;
	}
	
	/**
	 * 自分の名前を答える
	 * @return 名前
	 */
	public String getName(){
		return name_;
	}
	
	/**
	 * プレイヤーに戦略を渡す。
	 * @param tactics 戦略
	 */
	void setTactics(Tactics tactics){
		this.tactics_ = tactics;
	}
}
