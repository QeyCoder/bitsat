package Thread.Concurrent.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class RaceSimulation{
	
	static int position = 0;
	static int racers = 10;
	static final Object _lock = new Object();
	
	public static void main(String args[]){
		
		CountDownLatch startSignal = new CountDownLatch(1);
		CountDownLatch endSignal = new CountDownLatch(racers);
		
		for(int i = 0; i < racers; i++){
				Thread racer = new Thread(new Racer((char)(65 + i),startSignal,endSignal));
				racer.start();
		}
		try{
			Thread.sleep(1000L);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("####### Begin #########");
		startSignal.countDown();
		try{
			endSignal.await();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("####### End #########");
	}


static class Racer implements Runnable{
	
	private char name;
	private CountDownLatch startSignal;
	private CountDownLatch endSignal;
	
	Racer(char name,CountDownLatch startSignal,CountDownLatch endSignal){
		this.name = name;
		this.startSignal = startSignal;
		this.endSignal = endSignal;
	}

	@Override
	public void run(){
		try{
			startSignal.await();	
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		for(int i = 0; i < 10; i++);
		synchronized(_lock){
			System.out.println("Racer '" + name + "' ranked " + ++position);
		}
		endSignal.countDown();
	}
}

}