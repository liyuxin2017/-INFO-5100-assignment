package javaass6;

public class MyIndexOutOfBoundException extends Exception {
	private static final long serialVersionUID = 1L;
	private int lowerBound = 0; // the lowest legal index value.
	private int upperBound = 9; // the highest legal index value.
	private int index; // the current index value.

	public MyIndexOutOfBoundException() {
	}

	public MyIndexOutOfBoundException(String msg) {
		super(msg);
	}

	public String toString() {
		String s = "Error Message: Index: " + index + ", but Lower bound: " + lowerBound + ", Upper bound: "
				+ upperBound;
		return s;
	}

	public static void main(String[] args) /*throws Exception*/ {
		int index = 10;
		try {
			if (index < 0 || index > 9) {
				MyIndexOutOfBoundException e = new MyIndexOutOfBoundException();
				e.setIndex(index);
				throw e;
			}
		} catch (MyIndexOutOfBoundException e) {
			System.out.println(e);
		}
	}

	public int getLowerBound() {
		return lowerBound;
	}

	public int getUpperBound() {
		return upperBound;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
