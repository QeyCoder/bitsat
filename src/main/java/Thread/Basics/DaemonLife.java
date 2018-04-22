package Thread.Basics;/*
 * Daemon thread is independent of its
 * parent and last long until all
 * user thread dies.
 */



public class DaemonLife{
	
	public static void main(String args[]){
	
		Runnable target = new UserThread();
		Thread userT = new Thread(target);
		
		Runnable daemon = new ServiceThread();
		Thread daemonT = new Thread(daemon);
		daemonT.setDaemon(true);
	
		userT.start();
		daemonT.start();
		
		try{
		
			Thread.sleep(2000L);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		System.out.println("Main thread exited.");
	}
}


class UserThread implements Runnable{

	@Override
	public void run(){
		System.out.println("User thread started.");
		try{
			Thread.sleep(10 * 1000L);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		System.out.println("User thread stopped.");
	}

}


class ServiceThread implements Runnable{

	@Override
	public void run(){
		System.out.println("Daemon thread started.");
		try{
			while(true){
				System.out.println("Daemon Thread is alive.");
				try{
					Thread.sleep(1000L);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}finally{
			System.out.println("Daemon thread stopped.");
		}
	}

}

