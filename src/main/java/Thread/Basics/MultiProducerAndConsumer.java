package Thread.Basics;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class MultiProducerAndConsumer{

	public static void main(String args[]){
	
		List<String> buffer = new ArrayList<>();
		SharedResource res = new SharedResource(buffer);
		Runnable prodTask1 = new ProducerTask(res,0,"Producer-1");
		Runnable prodTask2 = new ProducerTask(res,5,"Producer-2");
		Runnable consTask1 = new ConsumerTask("Consumer-1",res);
		Runnable consTask2 = new ConsumerTask("Consumer-2",res);
		
		ExecutorService exec = Executors.newCachedThreadPool();
		try{
			exec.execute(prodTask1);
			exec.execute(prodTask2);
			exec.execute(consTask1);
			exec.execute(consTask2);
		}finally{
			exec.shutdown();
		}
	
	}

}


class ProducerTask implements Runnable{

	private SharedResource res;
	private String name;
	private int n;
	
	ProducerTask(SharedResource res, int n,String name){
		this.res = res;
		this.n = n;
		this.name = name;
	}

	@Override
	public void run(){
		
		int cntr = 65 + n;
		List<String> buffer = res.getBuffer();
		for(int i = 0; i < 5; i++ ){
			String product = "Prod-" + (char)(cntr + i);
			synchronized(this.getClass()){
				while(buffer.size() >= res.max){
					synchronized(res.getSharedLock()){
						try{
							System.out.println("Producer  = '" + name + " going to wait.");
							res.getSharedLock().wait();
						}catch(InterruptedException e){
							e.printStackTrace();
						} 	
					}
				}
				buffer.add(product);
				System.out.println("Producer  = '" + name + "' produces product = " + product);
				synchronized(res.getSharedLock()){
					res.getSharedLock().notifyAll();
				}
			}
		
		}
		res.stop();
		System.out.println("Producer = '" + name + "' closed.");
	
	}

}

class ConsumerTask implements Runnable{

	private String name;
	private SharedResource res;
	
	ConsumerTask(String name,SharedResource res){
		this.name = name;
		this.res = res;
	}

	@Override
	public void run(){

		List<String> buffer = res.getBuffer();
		while(!(res.isStop() && buffer.isEmpty())){
			synchronized(this.getClass()){
				if(!buffer.isEmpty()){
					
					String prod = buffer.remove(0);
					System.out.println("Consumer = '" + name + "' consumed product = " + prod);
					synchronized(res.getSharedLock()){
						res.getSharedLock().notifyAll();
					}
				}
			}
			if(buffer.isEmpty()){
				synchronized(res.getSharedLock()){
					try{
						System.out.println("Consumer  = '" + name + " going to wait.");
						res.getSharedLock().wait(500L); //If we don't specify waiting time,then it may  miss a 'notifyAll' signal.
					}catch(InterruptedException e){
						e.printStackTrace();
					}	
				}
			}
		}
	
		System.out.println("Consumer  = '" + name + "' closed.");
	}
	

}




class SharedResource {

	private Object monitor = new Object();
	private List<String> buffer;
	private volatile boolean stop;
	static final int max = 4; 
	
	SharedResource(List<String> buffer){
		this.buffer = buffer;
	}
	
	public Object getSharedLock(){
		return monitor;
	}
	
	public boolean isStop(){
		return stop;
	}

	public void stop(){
		this.stop = true;
	}
	
	public List<String> getBuffer(){
		return buffer;
	}

}