package roundzero.Thread.Concurrent.CountDownLatch;//import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchUtil{

	public static void main(String args[]){
		
		//CountDownLatch signal = new CountDownLatch(1);
		MyCountDownLatch signal = new MyCountDownLatch(1);
		
		System.out.println("Waiting for 2 seconds.");
		try{
			System.out.println("Current count = " + signal.getCount());
			signal.await(2,TimeUnit.SECONDS);
			System.out.println("Wait completed");
			signal.countDown();
			System.out.println("Current count = " + signal.getCount());
			signal.await(5,TimeUnit.SECONDS);
			System.out.println("Another wait completed");
			signal.countDown();
			System.out.println("Current count = " + signal.getCount());
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("Finish");
		
	
	}
}