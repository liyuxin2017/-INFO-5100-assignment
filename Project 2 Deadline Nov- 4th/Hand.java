package JavaProject2;

public class Hand extends GroupOfCards {
	Hand(int playerNum, int numberOfCards) {
		super(numberOfCards);
		NUM = playerNum;
	}

	public final int NUM;
	private int shortest;

	public void sort() {
		for (int unsorted = this.getCurrentSize(); unsorted > 0; unsorted--) {
			int maxIndex = unsorted - 1;
			for (int i = 0; i < unsorted; i++) {
				int currentValue = this.getCards(i).getSuit() * 13 + this.getCards(i).getNum();
				int maxValue = this.getCards(maxIndex).getSuit() * 13 + this.getCards(maxIndex).getNum();
				if (currentValue > maxValue)
					maxIndex = i;
			}
			Card card = this.removeCard(maxIndex);
			this.addCard(card);
		}
	}

	public void setShortest() {
		shortest = 0;
		if (this.findCount(1) <= this.findCount(0))
			shortest = 1;
		if (this.find(12, 3) == -1 && this.find(13, 3) == -1 && this.find(14, 3) == -1) {
			if (this.findCount(3) <= Math.min(this.findCount(0), this.findCount(1)))
				shortest = 3;
		}
	}

	public int getShortest() {
		return shortest;
	}

	public Card palyACard(Game game, Trick trick) {
		int index = 0;
		if ((trick.getCurrentSize() == 0) && (this.findCount(shortest) != 0)
				&& (index = this.findHighest(shortest)) >= 0)
			;
		else if ((trick.getCurrentSize() == 0) && (this.findCount(shortest) == 0)
				&& (index = this.findLowest(game)) >= 0)
			;
		else if ((trick.getCurrentSize() == game.PLAYERS - 1) && !trick.isHearts() && !trick.isQueen()
				&& (index = findLastHigh(trick.getWinningCard().getSuit())) >= 0)
			;
		else if ((index = findHighestBelow(trick.getWinningCard())) >= 0)
			;
		else if ((index = findMiddleHigh(game, trick.getWinningCard().getSuit())) >= 0)
			;
		else if ((index = find(12, 3)) >= 0)
			; // queen of Spades
		else if ((index = find(14, 3)) >= 0)
			; // Ace of Spades
		else if ((index = find(13, 3)) >= 0)
			; // King of Spades
		else if ((index = findHighest(2)) >= 0)
			; // heart
		else {
			index = findHighest();
		}
		Card card = this.removeCard(index);
		trick.update(NUM, card);
		game.updateHeartsAndQueen(card);
		return card;
	}

	private int find(int num, int suit) {
		for (int i = 0; i < this.getCurrentSize(); i++) {
			if (this.getCards(i).getNum() == num && this.getCards(i).getSuit() == suit)
				return i;
		}
		return -1;
	}

	private int findCount(int suit) {
		int count = 0;
		for (int i = 0; i < this.getCurrentSize(); i++)
			if (this.getCards(i).getSuit() == suit)
				count++;
		return count;
	}

	public int findLowest(int suit) {
		int lowest = -1;
		int lowestNum = 15;
		for (int i = 0; i < getCurrentSize(); i++)
			if (getCards(i).getSuit() == suit)
				if (getCards(i).getNum() <= lowestNum) {
					lowest = i;
					lowestNum = this.getCards(i).getNum();
				}
		return lowest;
	}

	private int findHighest(int suit) {
		int highest = -1;
		int highestNum = 1;
		for (int i = 0; i < getCurrentSize(); i++)
			if (getCards(i).getSuit() == suit)
				if (getCards(i).getNum() > highestNum) {
					highest = i;
					highestNum = getCards(i).getNum();
				}
		return highest;
	}

	private int findLowest(Game game) {
		int lowest = -1;
		int lowestNum = 15;
		if (game.getHearts() == false && findCount(2) == getCurrentSize())
			return lowest;
		if (game.getHearts() == true) {
			for (int i = 0; i < getCurrentSize(); i++)
				if (getCards(i).getNum() < lowestNum) {
					lowestNum = getCards(i).getNum();
					lowest = i;
				}
		} else {
			for (int i = 0; i < getCurrentSize(); i++)
				if (getCards(i).getNum() < lowestNum && getCards(i).getSuit() != 2) {
					lowestNum = getCards(i).getNum();
					lowest = i;
				}
		}
		return lowest;
	}

	private int findLastHigh(int suit) {
		if (suit != 3)
			return findHighest(suit);
		else {
			int highest = -1;
			int highestNum = 1;
			for (int i = 0; i < this.getCurrentSize(); i++)
				if (getCards(i).getSuit() == suit)
					if (getCards(i).getNum() > highestNum && getCards(i).getNum() < 12) {
						highest = i;
						highestNum = getCards(i).getNum();
					}
			return highest;
		}
	}

	private int findHighestBelow(Card winningCard) {
		for (int i = 0; i < getCurrentSize(); i++)
			if (getCards(i).getSuit() == winningCard.getSuit())
				if (getCards(i).getNum() < winningCard.getNum())
					if (i != getCurrentSize() - 1 && getCards(i + 1).getSuit() == winningCard.getSuit())
						return i;
		return -1;
	}

	private int findMiddleHigh(Game game, int suit) {
		if (suit == 3 && game.getQueenOfSpades() == false)
			for (int i = 0; i < getCurrentSize(); i++)
				if (getCards(i).getNum() <= 11)
					return i;
		return findHighest(suit);
	}

	private int findHighest() {
		int index = 0;
		int max = 1;
		for (int i = 0; i < getCurrentSize(); i++) {
			if (getCards(i).getNum() > max) {
				max = getCards(i).getNum();
				index = i;
			}
		}
		return index;
	}
}
