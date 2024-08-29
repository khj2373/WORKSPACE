package q.thread.ex2;

public class Task2 extends Thread {

	@Override
	public void run() {
		try {
			for (int i = 1; i < 20; i++) {
				if (i % 2 == 1) {
					System.out.println(i + " ");
				}
				Thread.sleep(2000); //0.2초간 정지
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
