package roundzero.Thread.Concurrent.Executors;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutionException;



public class FutureTaskWithSubmitTest {

	public static void main(String args[]){
		
		Callable<String> callable = new FutureCallableImpl();
		FutureTask<String> futureTask = new FutureTask<>(callable);
		ExecutorService exec = Executors.newSingleThreadExecutor();
		Future<String> asyncResult = null;
		try{
			asyncResult =  exec.submit(futureTask,"Return from argument.");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			exec.shutdown();
		}
		
		try{
			String result = asyncResult.get();
			System.out.println("result from new object = " + result);
			result = futureTask.get();
			System.out.println("result from  task object = " + result);
		}catch(InterruptedException | ExecutionException | RuntimeException e){
			e.printStackTrace();
		}
	
	}

}

class FutureCallableImpl implements Callable<String>{

	@Override
	public String call(){
	
		try{
			roundzero.Thread.sleep(5000L);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		return "Task completed.";
	}
} 