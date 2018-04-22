package Thread.Basics;/*
* If a thread has acquired two locks
* i.e in case of nested synchronized
* blocks, then calling wait() will
* only released the lock associated 
* with the object(if any) on which
* wait() is invoked, other locks 
* held will not be released. So
* stating that wait() will always
* release lock is not true in every case.
*/


public class DualLockWait{

	public static void main(String args[]){
			Object monitor1 = new Object();
			Object monitor2 = new Object();
			Runnable target = new WaitingRunnable(monitor1,monitor2);
			Thread t = new Thread(target);
			t.start();
			try{
				Thread.sleep(1000L);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.println("Main thread waiting for lock1.");
			synchronized(monitor1){
				System.out.println("Main Thread aqcuired lock1.");
			}
	}
}

class WaitingRunnable implements Runnable {
	
	private Object monitor1;
	private Object monitor2;
	
	WaitingRunnable(Object monitor1,Object monitor2){
		this.monitor1 = monitor1;
		this.monitor2 = monitor2;
	}

	
	@Override
	public void run(){
		
		synchronized(monitor1){
			System.out.println("Child thread acquired lock1.");
			synchronized(monitor2){
				System.out.println("Child thread acquired lock2, Now going to wait().");
				try{
					monitor2.wait(5000L);
				}catch(InterruptedException e){
					e.printStackTrace();
				}	
				System.out.println("Child thread released lock2.");
			}
			System.out.println("Child thread released lock1.");
		}
		
	
	}

}