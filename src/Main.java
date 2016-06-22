import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class T1 extends Thread {
	Random rand = new Random();

	public void run() {
		System.out.println("The thread is started!");
		try {
			Thread.sleep(1000 * (rand.nextInt(10)));
		} catch (InterruptedException e) {
			System.out.println(e);
			e.printStackTrace();
		}

		System.out.println("The thread complete!");
	}
}

public class Main {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(7);
		for (int i = 0; i < 6; i++) {
			T1 worker = new T1();
			executor.execute(worker);
			System.out.println("Thread " + i);
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}

		System.out.println("Finished all threads");
	}
}
