package babanuki;

public class Player {
	private Master master_;
	private Table table_;
	private Hand myHand_ = new Hand();
	private String name_;
	
	/**
	 * コンストラクタ
	 * @param name
	 * @param master
	 * @param table
	 */
	public Player(String name, Master master, Table table){
		this.name_ = name;
		this.table_ = table;
		this.master_ = master;
	}
	
	/**
	 * 順番を指名する。
	 * @param nextPlayer 次のプレイヤー
	 */
	public void play(Player nextPlayer){
		//次のプレイヤーに手札を出してもらう。
		Hand nextHand = nextPlayer.showHand();
		//相手の手札からカードを1枚引く。
		Card pickedCard = nextHand.pickCard();
		
		//引いたカードを表示
		System.out.println(this + ":" + nextPlayer + "さんから"+ pickedCard + "を引きました");
		
		//引いたカードを自分の手札に加え、同じ数のカードがあったら捨てる。
		dealCard(pickedCard);
		
		if(myHand_.getNumberOfCards() == 0){
			master_.declareWin(this);
		} else {
			System.out.println(this + ":残りの手札は " + myHand_ + "です");
		}
	}
	
	/**
	 * 手札を見せる。
	 * @return 自分の手札
	 */
	public Hand showHand(){
		// この時点で手札が残り1枚なら上がりなので、上がり宣言
		if(myHand_.getNumberOfCards() == 1){
			master_.declareWin(this);
		}
		
		myHand_.shuffle();
		
		return myHand_;
	}
	
	/**
	 * カードを受け取る
	 * @param card 受け取ったカード
	 */
	public void receiveCard(Card card){
		dealCard(card);
	}
	
	/**
	 * カードを自分の手札に加え、同じ数のカードがあったら捨てる。
	 * @param card 受け取ったカード
	 */
	private void dealCard(Card card){
		//カードを加える。
		myHand_.addCard(card);
		//今加えたカードと同じ数のカードを探す
		Card[] sameCards = myHand_.findSameNumberCard();
		
		//同じ数の組み合わせが存在する場合
		if(sameCards != null){
			System.out.print(this + ":");
			table_.disposeCard(sameCards);
		}
	}
	
	/**
	 * プレイヤーの名前を返す。
	 * @return プレイヤーの名前
	 */
	public String toString(){
		return name_;
	}
}
