package javaass7;

public class PascalTriangle {

	public static void main(String[] args) {
		printPascalTriangle(10);
	}

	public static void printPascalTriangle(int n) {
		if (n == 0)
			return;
		int[][] nums = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j <= i; j++)
				if (j == 0 || j == i)
					nums[i][j] = 1;
				else
					nums[i][j] = nums[i - 1][j - 1] + nums[i - 1][j];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++)
				System.out.print(nums[i][j] + " ");
			System.out.println();
		}
	}
}
