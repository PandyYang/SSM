package pandy.test.runandstart;

class ThreadDemo extends Thread {
	@Override
	public void run() {
		System.out.println("ThreadDemo : Begin");
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("ThreadDemo : End");
	}
}