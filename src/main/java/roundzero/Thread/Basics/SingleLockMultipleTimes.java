package roundzero.Thread.Basics;

public class SingleLockMultipleTimes{

	public synchronized static void main(String args[]){
		System.out.println("Inside main() using class lock.");
		synchronized(SingleLockMultipleTimes.class){
			System.out.println("Inside synchronized block using class lock.");
			takeLock();
		}	
	
	}

	private static synchronized void takeLock(){
		System.out.println("Inside takeLock() using class lock.");
	}	
	
}