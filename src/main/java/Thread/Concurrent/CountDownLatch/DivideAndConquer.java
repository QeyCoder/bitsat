package Thread.Concurrent.CountDownLatch;//import java.util.concurrent.CountDownLatch;

public class DivideAndConquer{
	
	static int[] arr = {10,45,12,33,54,91,233,61,137};
	static int n = 3;
	static int sum = 0;
	static final Object _lock = new Object();
	
	public static void main(String args[]){
		
		n = n < arr.length ? n : arr.length;
		int workerThreads = (arr.length + n - 1)/n; 
		MyCountDownLatch endSignal = new MyCountDownLatch(workerThreads);
		int k = 0;
		for(int i = 1; i < workerThreads; i++){
			int startIndex = k;
			int endIndex = k + workerThreads - 1;
			k = endIndex + 1;
			
			Thread worker = new Thread(new Worker(startIndex,endIndex,endSignal));	
			worker.start();
			
		}
		if(k < arr.length){
			int startIndex = k;
			int endIndex = arr.length - 1;
			Thread worker = new Thread(new Worker(startIndex,endIndex,endSignal));	
			worker.start();
		}
		
		try{
			endSignal.await();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("Total Asynchronous sum = " + sum);
		int syncSum = 0;
		for(int i = 0 ; i < arr.length; i++){
			syncSum += arr[i]; 
		}
		System.out.println("Total Synchronous sum = " + syncSum);
		
	}

	
	static class Worker implements Runnable{
		
		private int startIndex;
		private int endIndex;	
		private MyCountDownLatch endSignal;
	
		Worker(int startIndex, int endIndex,MyCountDownLatch endSignal){
			this.startIndex = startIndex;
			this.endIndex = endIndex;
			this.endSignal = endSignal;
		//	System.out.println("[" +  startIndex  + ',' + endIndex + ']');
		}
	
		@Override
		public void run(){
			for(int i = startIndex; i <= endIndex; i++ ){
				synchronized(_lock){
					sum += arr[i];
				}		
			}
			endSignal.countDown();
		}
	}
}