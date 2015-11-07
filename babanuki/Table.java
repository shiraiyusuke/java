package babanuki;

import java.util.ArrayList;

public class Table {
	//捨てられたカードリスト
	private ArrayList disposedCards_ = new ArrayList();
	
	public void disposeCard(Card card[]){
		for (int index = 0; index < card.length; index++){
			System.out.print(card[index] + " ");
		}
		System.out.println("を捨てました");
		
		disposedCards_.add(card);
	}
}
