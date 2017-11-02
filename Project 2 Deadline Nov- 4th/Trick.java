package JavaProject2;

public class Trick extends GroupOfCards {
	Trick(int players) {
		super(2 * players - 1);
		hearts = false;
		queen = false;
		winningCard = null;
	}

	private int winner;
	private Card winningCard;
	private boolean hearts;
	private boolean queen;

	public int getWinner() {
		return winner;
	}

	public Card getWinningCard() {
		return winningCard;
	}

	public boolean isHearts() {
		return hearts;
	}

	public boolean isQueen() {
		return queen;
	}

	private boolean isWinner(Card card) {
		if (winningCard != null)
			if (card.getSuit() != winningCard.getSuit() || card.getNum() < winningCard.getNum())
				return false;
		return true;
	}

	public void update(int playerNum, Card card) {
		this.addCard(card);
		if (this.isWinner(card)) {
			winner = playerNum;
			winningCard = card;
			if (card.getSuit() == 2)
				hearts = true;
			if (card.getSuit() == 3 && card.getNum() == 12)
				queen = true;
		}
	}
}
