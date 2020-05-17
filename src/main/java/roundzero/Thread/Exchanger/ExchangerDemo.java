package roundzero.Thread.Exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.List;
import java.util.ArrayList;


class ExchangerDemo{


	public static void main(String args[]){
	
		Exchanger<List<String>> exchanger = new Exchanger<>();
		BooleanVo stopFlag  = new BooleanVo();
		int MAX = 3;
		Runnable producer  = new ProducerExchanger(exchanger,stopFlag,MAX);
		Runnable consumer  = new ConsumerExchanger(exchanger,stopFlag,MAX);
		
		ExecutorService exec = Executors.newCachedThreadPool();
		try{
			exec.execute(producer);
			exec.execute(consumer);
		}finally{
			exec.shutdown();
		}
	
	
	}


}

class ProducerExchanger implements Runnable{

	private Exchanger<List<String>> exchanger;
	private BooleanVo stopFlag;
	private int MAX;
	
	ProducerExchanger(Exchanger<List<String>>  exchanger, BooleanVo stopFlag,int MAX){
		this.exchanger = exchanger;
		this.stopFlag = stopFlag;
		this.MAX = MAX;
	}
	
	
	@Override
	public void run(){
		
		int n = 10;
		List<String> buffer = new ArrayList<>(3);
		
		for(int i = 0; i < n; i++){
			String product = "Prod-" + (char)(65 + i);
			buffer.add(product);
			if(buffer.size() == MAX || i == n-1){
				System.out.println("Producer produces = " + buffer);
				try{
					buffer = exchanger.exchange(buffer);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
				
		}
		
		stopFlag.stop();
		System.out.println("Producer finished.");
	}
	

}

class ConsumerExchanger implements Runnable{

	private Exchanger<List<String>> exchanger;
	private BooleanVo stopFlag;
	private int MAX;
	
	ConsumerExchanger(Exchanger<List<String>> exchanger,BooleanVo stopFlag, int MAX ){
		this.exchanger = exchanger;
		this.stopFlag = stopFlag;
		this.MAX = MAX;
	}

	@Override
	public void run(){
	
		List<String> buffer = new ArrayList<>();
		while(!stopFlag.isStopped()){
			buffer.clear();
			try{
				buffer = exchanger.exchange(buffer,500L,TimeUnit.MILLISECONDS);
			}catch(InterruptedException | TimeoutException e){
				e.printStackTrace();
			
			}
			
			if(!buffer.isEmpty()){
				System.out.println("Consumer consumes = " + buffer);
			}
			
		}
		System.out.println("Consumer finished.");
	
	
	}

}

class BooleanVo{

	private volatile boolean isStop;
	
	boolean isStopped(){
		return isStop;
	}
	
	void stop(){
		isStop = true;
	}


}
