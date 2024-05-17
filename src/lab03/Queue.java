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
		Currency st = new Dollar();
		return st;
	}
	
	public Currency peekRear()
	{
		Currency st = new Dollar();
		return st;
	}
	
	public String printStack()
	{
		return "";
	}
	
	public void destroyStack() // optional
	{
		
	}
}
