package roundzero.Thread.Concurrent.Executors;

import java.util.List;
import java.util.ArrayList;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ExecuteCallables{

	private static final Object monitor = new Object();

	public static void main(String args[]){
		
		int maxPoolSize = 5;
		BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(maxPoolSize); 
		int corePoolSize = 1;
		long timeOut = 0L;
		ThreadFactory tFactory = ThreadFactoryImpl.getInstance();
		ExecutorService exec = new ThreadPoolExecutor(corePoolSize,maxPoolSize,timeOut,TimeUnit.MILLISECONDS,workQueue,tFactory);
		List<FutureTask<String>> futureTasks = getAsyncTasks();
		try{
			for(FutureTask<String> fTask : futureTasks){
				synchronized(monitor){
				int size = workQueue.size();
				while(size > 5){
					try{
						//System.out.println("Going to sleep as workQueue size = " + size);
						roundzero.Thread.sleep(2000L);
						size = workQueue.size();
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
				System.out.println("Going to execute task. , size = " + size);
				exec.execute(fTask);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			exec.shutdown();
		}
		System.out.println("Main thread exits.");
	}

	
	private static List<FutureTask<String>> getAsyncTasks(){
		
		final int n = 10;
		List<FutureTask<String>> futureTasks = new ArrayList<>();
		for(int i = 0; i < n;i++){
			Callable<String> task = new CallableImpl("roundzero.Thread-" + (char)(65 + i));
			FutureTask<String> futureTask = new FutureTask<>(task);
			futureTasks.add(futureTask);
		}
		return futureTasks;
	}
	
	
	

}



class CallableImpl implements Callable<String> {

	private String name;
	
	CallableImpl(String name){
		this.name = name;
	}
	
	@Override
	public String call() throws Exception{
	
		roundzero.Thread.sleep(5000L);
		System.out.println(name + " task successfully executed by " + roundzero.Thread.currentThread().getName());
		return "Task completed.";
	}
	
}

class ThreadFactoryImpl implements ThreadFactory{

	private int counter;
	private static final ThreadFactory instance = new ThreadFactoryImpl();
	
	private ThreadFactoryImpl(){
	
	}
	
	static ThreadFactory getInstance(){
		return instance;
	} 
	

	@Override
	public synchronized Thread newThread(Runnable command){
				Thread t = new Thread(command,"roundzero.Thread-" + ++counter);
				//t.setDaemon(true);
				System.out.println("Created Worker roundzero.Thread = " + counter);
				return t;
	
	}
	
	
	

}




