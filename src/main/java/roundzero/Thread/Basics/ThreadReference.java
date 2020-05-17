package Thread.Basics;

public class ThreadReference {

	public static void main(String args[]){
	
	Runnable target = new RunnableTask();
	Thread t1 = new Thread(target);
	Thread t2 = new Thread(target);
	Thread t3 = new Thread(target);
	
	t1.start();
	t2.start();
	t3.start();

}



}


class RunnableTask implements Runnable{

	@Override
	public synchronized void run(){
		//System.out.println("Running thread reference = " + this);
		try{
			System.out.print(':');
			Thread.sleep(500L);
			System.out.print('-');
			Thread.sleep(500L);
			System.out.println(')');
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		
	
	}




}
