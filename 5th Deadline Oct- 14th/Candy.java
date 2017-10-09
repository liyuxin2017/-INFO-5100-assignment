package javaass5.DessertShoppe;

public class Candy extends DessertItem{
	private double weight;
	private int pricePerPound;
	public Candy(String name, double weight, int pricePerPound) {
		this.name = name;
		this.weight = weight;
		this.pricePerPound = pricePerPound;
	}
	public int getCost() {
		int cost = (int) Math.round(weight * pricePerPound);
		return cost;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public int getPricePerPound() {
		return pricePerPound;
	}
	public void setPricePerPound(int pricePerPound) {
		this.pricePerPound = pricePerPound;
	}

}
