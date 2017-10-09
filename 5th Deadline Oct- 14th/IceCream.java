package javaass5.DessertShoppe;

public class IceCream extends DessertItem{
	protected int cost;
	public IceCream(String name, int cost) {
		this.name = name;
		this.cost = cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getCost() {
		return cost;
	}
}
