package roundzero.Thread.Concurrent.Executors;

import java.util.concurrent.FutureTask;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/*
* If we need to execute a list of
* Runnable/Callable and do want 
* to persist each of the corresponding
* Future object, So that we can keep
* track.
*
* Then we will have to create a new collection/map
* to save mapping of each of the Callable/Runnable to 
* its Future object.
*
* Instead of doing that we can use FutureTask<V>
* which implicitly bind the Furture and Runnable/Callable
* functionality within a single object.
*
*
*/

public class FutureRunnableTask {

	public static void main(String args[]){
		
		Callable<String> task = new CallableFutureTask();
		FutureTask<String> futureTask = new FutureTask<>(task);	
		ExecutorService exec = Executors.newSingleThreadExecutor();
		try{
			exec.execute(futureTask);
		}finally{
			exec.shutdown();
		}
		System.out.println("Waiting for the result of async task.");
		try{
			System.out.println("Result = " + futureTask.get());
		}catch(ExecutionException | InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("Main thread exits.");
	}
	
}



class CallableFutureTask implements Callable<String>{


	public String call() throws Exception{
		System.out.println("Executing Task.");
		roundzero.Thread.sleep(5000L);
		return "Task Completed.";
	
	}


}





