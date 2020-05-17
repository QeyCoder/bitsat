package roundzero.Thread.Basics;/*
* As soon as last user thread dies
* jvm will exit by terminating abruptly
* all daemon threads.And this causes 
* daemon threads to terminate their run
* without executing their finally block.
*/

public class FinallyAndDaemon{

	public static void main(String args[]){
			
			Thread t = new Thread(new HelperThread());
			t.setDaemon(true);
			t.start();
			try{
				roundzero.Thread.sleep(50L);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.println("Main exits");
	}

}

class HelperThread implements Runnable{


	@Override
	public void run(){
		try{
			for(int i = 0; i < 100 ; i++){
				System.out.println("Daemon printed = " + i);
			}
		
		}finally{
			System.out.println("In finally block.");
		}
		
	}

}