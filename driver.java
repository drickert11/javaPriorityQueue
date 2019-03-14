import java.util.Random;
//Dustin Rickert
public class driver {
	public static void main(String[] args){
		//initializes queue
		PriorityQueue pqueue=new PriorityQueue();		
		for(int i=0;i<60;i++){
			if(pqueue.isEmpty()==true){
				//do nothing if true
			}
			else{
				pqueue.getFirst().decServiceTime();
				//used to initially detect error.
				//System.out.println(pqueue.getFirst().getPriority()+"\tService time: "+pqueue.getFirst().getServiceTime());
				
				
				//if customer is serviced
				if(pqueue.getFirst().getServiceTime()==0){
					pqueue.remove();
					System.out.println("Customer serviced and removed from the queue.  Quest length is now "+pqueue.getSize());					
				}
			}
				//25% chance for new customer to add to queue
			int num= new Random().nextInt(4)+1;
			if(num==4){
					PriorityCustomer c=new PriorityCustomer();
					pqueue.addCustomer(c);
					System.out.println("New customer added!  Queue length is now "+pqueue.getSize());
			}
				//per minute			
			System.out.println("-----------------------------------------------------------------------");
		}
		//final output
		System.out.println("The total number of customers serviced is "+pqueue.getTotal()+"\nThe Maximum number of people in the queue at a time is "+pqueue.getMax());
	}		
}