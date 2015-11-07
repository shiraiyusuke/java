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
	private Player(String name, Master master, Table table){
		this.name_ = name;
		this.table_ = table;
		this.master_ = master;
	}
	
	public void play(Player nextPlayer){
		//次のプレイヤーに手札を出してもらう。
		Hand nextHand = nextPlayer.showHand();
		//相手の手札からカードを1枚引く。
		Card pickedCard = nextHand.pickCard();
		
		//引いたカードを表示
		System.out.println(this + ":" + nextPlayer + "さんから"+ pickedCard + "を引きました");
		
		//引いたカードを自分の手札に加え、同じ数のカードがあったら捨てる。
		dealCard(pickedCard);
	}
}
