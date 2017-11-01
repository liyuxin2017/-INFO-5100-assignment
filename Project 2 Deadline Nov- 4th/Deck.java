package JavaProject2;

import java.util.Random;

public class Deck extends GroupOfCards {

	public Deck() {
		super(52);
		for (int i = 2; i <= 14; i++)
			for (int j = 0; j <= 3; j++)
				this.addCard(new Card(i, j));
	}

	public void shuffle() {
		for (int unshuffled = this.getCurrentSize(); unshuffled > 0; unshuffled--) {
			Random r = new Random();
			Card card = this.removeCard(r.nextInt(unshuffled));
			this.addCard(card);
		}
	}

	public Card dealCard() {
		return this.removeCard(0);
	}
}
