package JavaProject2;

public class GroupOfCards {
	public GroupOfCards(int number) {
		super();
		cards = new Card[number];
		currentSize = 0;
	}

	private Card[] cards;
	private int currentSize;

	public Card getCards(int i) {
		return cards[i];
	}

	public int getCurrentSize() {
		return currentSize;
	}

	public void addCard(Card card) {
		if (currentSize == cards.length) {
			System.out.println("full cards!");
			return;
		}
		cards[currentSize] = card;
		currentSize += 1;
	}

	public Card removeCard(int index) {
		if (index >= currentSize) {
			System.out.println("index wrong!");
			return null;
		}
		Card res = cards[index];
		currentSize -= 1;
		cards[index] = null;
		if (currentSize > 0) {
			for (int i = index; i < currentSize; i++) {
				cards[i] = cards[i + 1];
			}
			cards[currentSize] = null;
		}
		return res;
	}

	public void display() {
		System.out.println("current size: " + currentSize);
		for (int i = 0; i < currentSize; i++) {
			cards[i].display();
		}
	}
}
