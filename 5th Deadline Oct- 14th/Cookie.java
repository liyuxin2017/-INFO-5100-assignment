package javaass5.DessertShoppe;

public class Cookie extends DessertItem{
	private int number;
	private int pricePerDozen;
	public int getCost() {
		double cost = number * pricePerDozen / 12 ;
		return (int) Math.round(cost);
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getPricePerDozen() {
		return pricePerDozen;
	}
	public void setPricePerDozen(int pricePerDozen) {
		this.pricePerDozen = pricePerDozen;
	}
	public Cookie(String name, int number, int pricePerDozen) {
		this.name = name;
		this.number = number;
		this.pricePerDozen = pricePerDozen;
	}
}
