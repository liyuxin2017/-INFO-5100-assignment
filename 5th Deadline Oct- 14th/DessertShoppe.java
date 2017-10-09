package javaass5.DessertShoppe;

public class DessertShoppe {
	static double taxRate = 0.07;
	static String name = "Yuxin Dessert Shoppe";
	static int maximumSizeOfItemName = 25;
	static int Width2DisplayCosts = 35;
	public static String centsToDollarsAndCents(int cent) {
		String result = cent / 100 + "." + (cent % 100) / 10 + cent % 10;
		return result;
	}
}
