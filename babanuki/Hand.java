package babanuki;

import java.util.ArrayList;

public class Hand {
	private ArrayList hand_ = new ArrayList();
	
	/**
	 * カードを加える。
	 * @param card
	 */
	public void addCard(Card card){
		hand_.add(card);
	}
	
	/**
	 * カードを引く。
	 * @return 引いたカード
	 */
	public Card pickCard(){
		Card pickedCard = (Card) hand_.remove(0);
		return pickedCard;
	}
	
	/**
	 * シャッフルする
	 */
	public void shuffle(){
		int number = hand_.size();
		
		int pos;
		
		for(int count = 0; count < number * 2 ; count++){
			//ランダムな位置からカードを1枚抜く。
            pos = (int) (Math.random() * number);
            Card pickedCard = (Card) hand_.remove(pos);

            //抜いたカードを最後に加える。
    		hand_.add(pickedCard);
		}
	}
	
	/**
	 * 枚数を数える。
	 * @return 手札のカードの枚数
	 */
	public int getNumberOfCards(){
		return hand_.size();
	}
	
	/**
	 * 同じ数のカードを探す。
	 * 同じ数のカードがなければ、nullを返す。
	 * @return 同じ数のカード
	 */
	public Card[] findSameNumberCard(){
		int numberOfCards = hand_.size();
		Card[] sameCards = null;
		
		if(numberOfCards > 0){
			//最後に追加されたカードを取得
			int lastIndex = numberOfCards - 1;
			Card lastAddedCard = (Card) hand_.get(lastIndex);
			
			//最後に追加されたカードの数字を取得する。
			int lastAddedCardNum = lastAddedCard.getNumber();
			
			for(int index = 0; index < lastIndex; index++){
				Card card = (Card) hand_.get(index);
				if(card.getNumber() == lastAddedCardNum){
					//同じ数のカードが見つかったら、ループエンド
					sameCards = new Card[2];
					sameCards[0] = (Card) hand_.remove(lastIndex);
					sameCards[1] = (Card) hand_.remove(index);
					
					break;
				}
			}
		}
		return sameCards;
	}
	
	/**
	 * 手札にあるカードを文字列で表現
	 */
	public String toString(){
		StringBuffer string = new StringBuffer();
		int size = hand_.size();
		if(size > 0){
			for (int index = 0; index < size; index++){
				Card card = (Card) hand_.get(index);
				string.append(card);
				string.append(" ");
			}
		}
		
		return string.toString();
	}
}
