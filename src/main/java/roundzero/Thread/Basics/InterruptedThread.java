package Thread.Basics;

public class InterruptedThread{

	public static void main(String args[]){
	
		//Runnable target = new InterruptedChildThread();
		
		Runnable target = new SleepingThread();
		Thread t = new Thread(target);
		t.start();
	
		try{
			Thread.sleep(5000L);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("Main thread awake.");
		t.interrupt();
		System.out.println("Child thread interrupted.");
	
	
	}

}


class InterruptedChildThread implements Runnable{


	@Override
	public void run(){
			System.out.println("Child Thread started.");
			int i = 0;
			Thread t = Thread.currentThread();
			while(!t.isInterrupted());
			
			System.out.println("Child Thread stopped.");
	
	}

}

class SleepingThread implements Runnable{

	@Override
	public void run(){
		System.out.println("Sleeping Thread started.");
		try{
			Thread.sleep(100 * 1000L);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		System.out.println("Sleeping Thread stopped.");
	
	}

}









