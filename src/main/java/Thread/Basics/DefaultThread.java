package Thread.Basics;

public class DefaultThread{

	public static void main(String args[]){
	
		Thread t = Thread.currentThread();
		/*
		* Thread state to daemon or non-daemon
		* can only be changed before starting the
		* execution of thread, otherwise it will
		* throw IllegalThreadStateException.
		*/
		//t.setDaemon(true);
		System.out.println("Is Daemon thread = " + t.isDaemon());
	
	}
}