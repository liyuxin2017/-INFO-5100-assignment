package javaass5.DessertShoppe;

public class Sundae extends IceCream{
	private String nameOfTopping;
	private int costOfTopping;
	public Sundae(String name, int cost, String nameOfTopping, int costOfTopping) {
		super(name, cost);
		this.nameOfTopping = nameOfTopping;
		this.costOfTopping = costOfTopping;
	}
	public String getNameOfTopping() {
		return nameOfTopping;
	}
	public void setNameOfTopping(String nameOfTopping) {
		this.nameOfTopping = nameOfTopping;
	}
	public int getCostOfTopping() {
		return costOfTopping;
	}
	public void setCostOfTopping(int costOfTopping) {
		this.costOfTopping = costOfTopping;
	}
	public int getCost() {
		return cost + costOfTopping;
	}
}
