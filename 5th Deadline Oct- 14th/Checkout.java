package javaass5.DessertShoppe;

import java.util.ArrayList;

public class Checkout {
	private ArrayList<DessertItem> items;
	private int numberOfItems;
	public Checkout() {
		items = new ArrayList<DessertItem>();
	}
	public int getNumberOfItems() {
		numberOfItems = items.size();
		return numberOfItems;
	}
	public void enterItem(DessertItem item) {
		this.items.add(item);
	}
	public void clear() {
		items.clear();
		numberOfItems = items.size();
	}
	public int totalCost() {
		int result = 0;
		for (int i = 0; i < items.size(); i++) {
			result = result + items.get(i).getCost();
		}
		return result;
	}
	public int totalTax() {
		int result = (int) Math.round(this.totalCost() * DessertShoppe.taxRate);
		return result;
	}
	public String toString() {
		String result = new String();
		result += DessertShoppe.name + "\n";
		for (int i = 0; i < DessertShoppe.name.length(); i++)
			result += "-";
		result += "\n";
		for (int i = 0; i < numberOfItems; i++) {
			if (items.get(i).name .length() < DessertShoppe.maximumSizeOfItemName) {
				result += items.get(i).name;
				String dollar = DessertShoppe.centsToDollarsAndCents(items.get(i).getCost());
				for (int j = 0; j <= DessertShoppe.Width2DisplayCosts - items.get(i).name.length() - dollar.length(); j++)
					result += " ";
				result += dollar + "\n";
			}
			else {
				result += items.get(i).name.substring(0, DessertShoppe.maximumSizeOfItemName);
				String dollar = DessertShoppe.centsToDollarsAndCents(items.get(i).getCost());
				for (int j = 0; j <= DessertShoppe.Width2DisplayCosts - DessertShoppe.maximumSizeOfItemName - dollar.length(); j++)
					result += " ";
				result += dollar + "\n";
				result += items.get(i).name.substring(DessertShoppe.maximumSizeOfItemName, items.get(i).name.length());
			}
		}
		result += "\nTax";
		for (int i = 0; i <= DessertShoppe.Width2DisplayCosts - "Tax".length() - DessertShoppe.centsToDollarsAndCents(this.totalTax()).length(); i++) {
			result += " ";
		}
		result += DessertShoppe.centsToDollarsAndCents(this.totalTax()) + "\n";
		result += "Total Cost";
		for (int i = 0; i <= DessertShoppe.Width2DisplayCosts - "Total Cost".length() - DessertShoppe.centsToDollarsAndCents(this.totalCost() + this.totalTax()).length(); i++) {
			result += " ";
		}
		result += DessertShoppe.centsToDollarsAndCents(this.totalCost() + this.totalTax()) + "\n";
		return result;
		
	}
}
