package JavaProject2;

public class Game {
	public Game(int numberOfPlayers) {
		super();
		PLAYERS = numberOfPlayers;
		players = new Hand[numberOfPlayers];
		for (int i = 0; i < players.length; i++)
			players[i] = new Hand(i, 52 / PLAYERS);
		tricks = new Trick[52 / PLAYERS];
		numberOfTricks = 0;
	}

	public final int PLAYERS;
	private Deck deck;
	private Hand[] players;
	private Trick[] tricks;
	private int numberOfTricks;
	private boolean hearts;
	private boolean queenOfSpades;

	public int getNumberOfTricks() {
		return numberOfTricks;
	}

	public boolean getHearts() {
		return hearts;
	}

	public boolean getQueenOfSpades() {
		return queenOfSpades;
	}

	public void playAGame() {
		deck = new Deck();
		int cardsLeft = 52 % PLAYERS;
		if (cardsLeft == 1)
			deck.removeCard(0);
		if (cardsLeft == 2) {
			deck.removeCard(0);
			deck.removeCard(0);
		}
		deck.shuffle();
		for (int i = 0; i < tricks.length; i++)
			for (int j = 0; j < PLAYERS; j++)
				players[j].addCard(deck.dealCard());
		int playerNum = 0;
		int temp = 15;
		for (int i = 0; i < PLAYERS; i++) {
			players[i].setShortest();
			players[i].sort();
			System.out.println("player " + i + " shortest = " + players[i].getShortest());
			players[i].display();
			if (players[i].getCards(tricks.length - 1).getSuit() == 0
					&& players[i].getCards(tricks.length - 1).getNum() < temp) {
				temp = players[i].getCards(tricks.length - 1).getNum();
				playerNum = i;
			}
			System.out.println();
		}
		for (int i = 0; i < tricks.length; i++) {
			tricks[i] = new Trick(PLAYERS);
			numberOfTricks++;
			Card card;
			if (i == 0) {
				int index = players[playerNum].getCurrentSize() - 1;
				card = players[playerNum].removeCard(index);
				tricks[i].update(playerNum, card);
			} else {
				card = players[playerNum].palyACard(this, tricks[i]);
			}
			System.out.print("player " + playerNum + "      ");
			card.display();
			for (int j = 1; j < PLAYERS; j++) {
				playerNum = (playerNum + 1) % PLAYERS;
				card = players[playerNum].palyACard(this, tricks[i]);
				System.out.print("player " + playerNum + "      ");
				card.display();
			}
			playerNum = tricks[i].getWinner();
			if (i == 0) {
				if (cardsLeft == 1)
					System.out.println("undelt card   card: clubs 2");
				if (cardsLeft == 2) {
					System.out.println("undelt card   card: clubs 2");
					System.out.println("undelt card   card: diamonds 2");
				}
			}
			System.out.println();
		}
		for (int i = 0; i < PLAYERS; i++)
			System.out.println("players " + i + "  score = " + computePoints(i));
	}

	public void updateHeartsAndQueen(Card card) {
		if (card.getSuit() == 2 && hearts == false) {
			System.out.println("Hearts is now broken");
			hearts = true;
		}
		if (card.getSuit() == 3 && card.getNum() == 12)
			queenOfSpades = true;
	}

	private int computePoints(int playerNum) {
		int point = 0;
		for (int i = 0; i < numberOfTricks; i++) {
			if (tricks[i].getWinner() == playerNum)
				for (int j = 0; j < PLAYERS; j++) {
					if (tricks[i].getCards(j).getSuit() == 2)
						point++;
					if (tricks[i].getCards(j).getSuit() == 3 && tricks[i].getCards(j).getNum() == 12)
						point += 13;
				}
		}
		return point;
	}
}
