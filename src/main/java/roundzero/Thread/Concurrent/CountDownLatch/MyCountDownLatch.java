package roundzero.Thread.Concurrent.CountDownLatch;

import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;


public class MyCountDownLatch{

	private long count;
	private final Object _lock = new Object();
	
	public MyCountDownLatch(long count){
		if(count < 0){
			throw new IllegalArgumentException("Count = " + count + " must not be less than zero.");
		}
		this.count = count;	
		
	}

	public void countDown(){
		synchronized(_lock){
			if(count != 0){
				--count;
			}
		}
	}

	public long getCount(){
		return count;
	}

	public void await() throws InterruptedException {
		while(count != 0L);
	}

	public boolean await(long time,TimeUnit timeUnit) throws InterruptedException {
		if(count == 0){
			return true;
		}
		final long timeMillis = timeUnit.toMillis(time);
		final Map<String,Boolean> container = new HashMap<>();
		container.put("sleepCompleted",false);
		Thread t = new Thread(new Runnable(){
			
			@Override
			public void run(){
				try{
					Thread.sleep(timeMillis);
				}catch(InterruptedException e){
					e.printStackTrace();
				}finally{
					container.put("sleepCompleted",true);
				}
			}
		});
		t.start();
		while(!container.get("sleepCompleted") && count != 0);
		if(count == 0){
			return true;
		}else{
			return false;
		}
	}
}