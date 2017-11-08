package javaass7;

import java.util.Random;

public class MaxValue {
	public static void main(String[] args) throws InterruptedException {
		int[] arr = new int[100];
		Random rd = new Random();
		for (int i = 0; i < arr.length; i++)
			arr[i] = rd.nextInt(1000);
		int maxValue = findMaxValue(arr);
		System.out.println("Max value: " + maxValue);
	}

	static int findMaxValue(int[] arr) throws InterruptedException {
		maxValueThread[] threads = new maxValueThread[4];
		for (int i = 0; i < 4; i++) {
			threads[i] = new maxValueThread(i, arr);
			threads[i].start();
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < 4; i++) {
			threads[i].join();
			max = Math.max(max, threads[i].maxValue);
		}
		return max;
	}
}

class maxValueThread extends Thread {
	int num;
	int[] arr;
	int maxValue;

	public maxValueThread(int n, int[] arr) {
		this.num = n;
		this.arr = arr;
		this.maxValue = Integer.MIN_VALUE;
	}

	public void run() {
		super.run();
		for (int i = num; i < arr.length; i = i + 4)
			maxValue = Math.max(arr[i], maxValue);
	}
}
