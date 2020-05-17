package roundzero.Thread.Basics;

public class ParentThread{

	public static void main(String args[]){
		
		Runnable r = new ChildThread();
		Thread t = new Thread(r);
		t.setDaemon(true);
		t.start();
		try{
			roundzero.Thread.sleep(1000L);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("Parent thread terminated.");
	}
}



class ChildThread implements Runnable{

	@Override
	public void run(){
		Thread t = roundzero.Thread.currentThread();
		
		System.out.println("Is Daemon thread = " + t.isDaemon());
		int i = 0;
		while(i++ < 58){
			try{
				roundzero.Thread.sleep(500L);
				System.out.println("Child thread running : " + i);
				
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	
	
	}

}