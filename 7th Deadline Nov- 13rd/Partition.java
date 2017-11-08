package javaass7;

public class Partition {

	public static void main(String[] args) {
		int[] arr = { 6, 78, 4, 7, 98, 3, 6, 76, 45, 3, 87, 78, 4, 1 };
		System.out.println("Output: " + findPartition(arr));
	}

	public static boolean findPartition(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++)
			sum += arr[i];
		if (sum % 2 == 1)
			return false;
		return findPartition(arr, arr.length - 1, sum / 2, sum / 2);
	}

	public static boolean findPartition(int[] arr, int current, int sum1, int sum2) {
		if (sum1 < 0 || sum2 < 0)
			return false;
		if (sum1 == 0 || sum2 == 0)
			return true;

		return findPartition(arr, current - 1, sum1 - arr[current], sum2)
				|| findPartition(arr, current - 1, sum1, sum2 - arr[current]);
	}
}
