package JavaProject2;

public class Card {
	public Card(int num, int suit) {
		super();
		this.num = num;
		this.suit = suit;
	}

	private int num;
	private int suit;

	public int getNum() {
		return num;
	}

	public int getSuit() {
		return suit;
	}

	public void display() {
		System.out.print("card: ");
		String suits = new String();
		switch (suit) {
		case 0:
			suits = "clubs";
			break;
		case 1:
			suits = "diamonds";
			break;
		case 2:
			suits = "hearts";
			break;
		case 3:
			suits = "spades";
			break;
		}
		System.out.print(suits + " ");
		switch (num) {
		case 11:
			System.out.println("J");
			break;
		case 12:
			System.out.println("Q");
			break;
		case 13:
			System.out.println("K");
			break;
		case 14:
			System.out.println("A");
			break;
		default:
			System.out.println(num);
		}
	}
}
