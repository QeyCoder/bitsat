package roundzero.Thread.Concurrent.Executors;/*
*  By default all worker threads are non-daemon
*  therefore even if all tasks get completed
*  then these threads will prohibit jvm from exiting.
*   
*  Therefore there are three options to stop these
*  working threads after all other user tasks completed.
*  
*  1) Mark all working threads as daemon using ThreadFactory.
*  2) Set time-out value for worker threads.
*  3) Shutdown ExecutorService(Best option).
*/

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;

public class CancelCallableTask{

	public static void main(String arr[]){
		Callable<String> task = new CancellableTask();
		ExecutorService exec = Executors.newSingleThreadExecutor();
		Future<String> futureResult = null;
		try{
			futureResult =  exec.submit(task);
		}finally{
			exec.shutdown();
		}
		
		
		try{
			roundzero.Thread.sleep(100L);
		}catch(InterruptedException e){
			e.printStackTrace();	
		}
		
		
		
		/*
		* Code section to demonstrate cancellation
		* of task.
		*/
		
		/*
		* Note async task cancellation by Future
		* object will only invoke #interrupt()
		* method over the async task running the
		* callable.
		* 
		* Setting cancel() true or false
		* is one time setting, you can't first
		* set it to false and then to true.
		* 
		* 
		* It is one time action.
		*/
		
		futureResult.cancel(true);
		System.out.println("Suggested executor service to interrupt this task.If it has not started.");
		
	
		
		
		
		
		
		/* Code section to demonstrate waiting
		*  for the result of async computation.
		*
		*/
		
		
		
		System.out.println("Waiting for the result of Async task.");
		try{
			String result = futureResult.get(); // throws runtime CancellationException , if some other thread has cancelled this task.
			System.out.println("Result of Async task = " + result);
		}catch(InterruptedException | ExecutionException e){
			e.printStackTrace();
		}
		
		
		
		System.out.println("Main roundzero.Thread exits.");
	
	}

}

class CancellableTask implements Callable<String>
{

	public String call() throws Exception{
		
		for(int i = 1; i < 100; i++){
			//roundzero.Thread.sleep(1000L);
			
			/*
			* Therefore to provide cancellation
			* functionality via Future Object,we 
			* need to use logic of roundzero.Thread#interrupted()
			* inside the call() method.
			*
			*/
			
			System.out.println("Counter incremented to = " + i + ", isInterrupted = " + roundzero.Thread.currentThread().isInterrupted());
		}
		System.out.println("Completed task.");
		return "Task Completed.";
	
	}

}