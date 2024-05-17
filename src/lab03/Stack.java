package lab03;

public class Stack
{
	private SinglyLinkedList list;
	
	public Stack()
	{
		list = new SinglyLinkedList();
	}
	
	public void createStack() // optional, change return type later
	{
		
	}
	
	/*
	 * start = top of stack
	 */
	public void push(Currency curr)
	{
		list.addCurrency(curr, 0);
	}
	
	public Currency pop()
	{
		return list.removeCurrency(0);
	}
	
	public Currency peek()
	{
		return list.getCurrency(0);
	}
	
	public String printStack()
	{
		return list.printList();
	}
	
	public void destroyStack() // optional
	{
		
	}
}
