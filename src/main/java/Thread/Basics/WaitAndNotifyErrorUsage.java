package Thread.Basics;/*
* Calling wait() and notify()
* methods outside the synchronized
* block throws IllegalMonitorStateException.
* Or more clearer calling wait() or notify()
* on an object on which it has not taken
* lock , will throw IllegalMonitorStateException.
*/


public class WaitAndNotifyErrorUsage{

	public static void main(String args[]){
			
			Object obj = new Object();
			try{
				System.out.println("Calling wait() without synchonized block.");
				obj.wait();
			}catch(InterruptedException | IllegalMonitorStateException e){
				e.printStackTrace();
			}
		
			try{
				System.out.println("Calling notify() without synchonized block.");
				obj.notify();
			}catch(IllegalMonitorStateException e){
				e.printStackTrace();
			}
	
	}

}