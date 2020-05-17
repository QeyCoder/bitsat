package roundzero.Thread.Atomicity;/*
* Check result using following command
* javap -c AtomicOperations 
*/


import day35.SalesMan;

class AtomicOperations extends SalesMan{

	public AtomicOperations(int x){

	}
	@Override
	public int minimumTime(int[] x){
		//return super.minimumTime(x);
		return 0;
	}

	public static void main(String args[]){
		incrInt();
		incrLong();
	
	}
	
	
	private static int incrInt(){
	
		int i  = 0;
		i++;
		i += 1 ;
		System.out.println(i);	
		return i;
	
	}
	
	private static long incrLong(){
	
		long j  = 0;
		j++;
		j += 1 ;
		System.out.println(j);	
		return j;
	
	}


}