package Thread.Basics;

public class CustomThread extends Thread{

	CustomThread(Runnable target){
		super(target);
	}
	

	@Override
	public void run(){
		super.run();
		System.out.println("Inside CustomThread.");
	}
	
	public static void main(String args[]){
		Runnable target = new RunnableThread();
		Thread customThread = new CustomThread(target);
		customThread.start();
	}

}


class RunnableThread implements Runnable{

	@Override
	public void run(){
		System.out.println("Inside RunnableThread.");
	
	}

}