package lab03;

public class Queue 
{
	private SinglyLinkedList list;
	
	public Queue()
	{
		list = new SinglyLinkedList();
	}
	
	public void createQueue() // optional, change return type later
	{
		
	}
	
	public void destroyStack() // optional
	{
		
	}
	
	/*
	 * list's head node = queue's front
	 * list's tail node = queue's end
	 * 
	 * takes a Currency object as parameter and adds it to the end of the queue
	 */
	public void enqueue(Currency curr)
	{
		list.addCurrency(curr, list.getCount());
	}
	
	public Currency dequeue()
	{
		return list.removeCurrency(0);
	}
	
	public Currency peekFront()
	{
		return list.getCurrency(0);
	}
	
	public Currency peekRear()
	{
		return list.getCurrency(list.getCount() - 1);
	}
	
	public String printStack()
	{
		return list.printList();
	}
	
}
