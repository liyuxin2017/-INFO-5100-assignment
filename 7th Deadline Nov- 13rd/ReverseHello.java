package javaass7;

public class ReverseHello {
	public static void main(String[] args) throws InterruptedException {
		ThreadList tl = new ThreadList(1);
		tl.start();
	}
}

class ThreadList extends Thread {
	int num;

	public ThreadList(int n) {
		this.num = n;
	}

	public void run() {
		super.run();
		if (num == 50) {
			System.out.println("Hello from Thread " + num);
			return;
		}
		ThreadList tl = new ThreadList(num + 1);
		tl.start();
		try {
			tl.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Hello from Thread " + num);
	}
}