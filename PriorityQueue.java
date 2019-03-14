public class PriorityQueue {
	//Dustin Rickert
	private PriorityCustomer[] line;
	private int size;
	private int max;
	private int tot;
	//constructor
	public PriorityQueue(){
		line= new PriorityCustomer[50];
		size=0;
		max=0;
		tot=0;
	}
	//returns max
	public int getMax(){
		return max;
	}
	//returns total
	public int getTotal(){
		return tot;
	}
	//updates max
	public void isMax(){
		if(size>max){
			max=size;
		}
	}
	//returns size
	public int getSize(){
		return size;
	}
	//returns first object
	public PriorityCustomer getFirst(){
		return line[1];
	}
	//checks if empty
	public boolean isEmpty(){
		if(size==0){
			return true;
		}
		else{
			return false;
		}
	}
	//adds customer
	public void addCustomer(PriorityCustomer cust){
		size++;
		isMax();
		line[size]=cust;
		int ind=size;
		//typically whatever is in first will always be, being serviced so simply replace with next in line.
		while(ind>3){
				
			int par=ind/2;
			if(line[ind].getPriority()>line[par].getPriority()){
				line[ind]=line[par];
				line[par]=cust;
				ind=par;
			}
			else{
				break;
			}

		}
	}
	//switches first customer with last and deletes last, then resorts the heap accordingly
	public void remove(){
			line[1]=line[size];
			line[size]=null;
			size--;
			tot++;
			int ind=1;
			int count=0;
			boolean go=true;
			while(ind<=(size/2)&&(size/2)!=1&&go){
				//was getting a runtime error used this to find it
				//the loop was ind==size/2 though nothing would change. I implemented a counter to detect and break loop.
				//System.out.println("Index: "+ind+"\nSize "+size+"\nSize/2 "+(size/2)+"\ncount "+count+"\nboolean "+go+"\n++++++++++++++++");
					count++;
			
					
				if(count>20){
				go=false;		
				}
				
				int rightSubInd= ind*2;
				int leftSubInd=(ind*2)+1;
				int rightVal=line[rightSubInd].getPriority();
				int leftVal;
					if(line[(ind*2)+1]==null){
					leftVal=0;
					}
					else{
					leftVal=line[(ind*2)+1].getPriority();
					}
					int largerVal;
					int largerInd;
					if(rightVal<leftVal){
						largerVal=leftVal;
						largerInd=leftSubInd;
					}
					else{
						largerVal=rightVal;
						largerInd=rightSubInd;
					}
					if(line[ind].getPriority()<largerVal){
						line[0]=line[ind];
						line[ind]=line[largerInd];
						line[largerInd]=line[0];
						line[0]=null;
						ind=largerInd;		
				
					}
					

				
		}
			//first attempt to fix runtime error because I thought it was just 2 and 3 though doesnt affect outcome. Fixed loop when size equals 3 but not 5+ which is when used counter.
	         if(size==2||size==3){
	             ind=1;
	          	int rightSubInd= ind*2;
	 				int leftSubInd=(ind*2)+1;
	 				int rightVal=line[rightSubInd].getPriority();
	 				int leftVal;
	 					if(line[(ind*2)+1]==null){
	 					leftVal=0;
	 					}
	 					else{
	 					leftVal=line[(ind*2)+1].getPriority();
	 					}
	 					int largerVal;
	 					int largerInd;
	 					if(rightVal<leftVal){
	 						largerVal=leftVal;
	 						largerInd=leftSubInd;
	 					}
	 					else{
	 						largerVal=rightVal;
	 						largerInd=rightSubInd;
	 					}
	 					if(line[ind].getPriority()<largerVal){
	 						line[0]=line[ind];
	 						line[ind]=line[largerInd];
	 						line[largerInd]=line[0];
	 						line[0]=null;
	 						//ind=largerInd;
	 					}
	                }
	}
}

