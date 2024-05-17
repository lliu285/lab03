package lab03;

public class Stack extends SinglyLinkedList
{
	public Stack()
	{
		super();
	}
	
	public void createStack() // optional, change return type later
	{
		
	}
	
	/*
	 * start = top of stack
	 */
	public void push(Currency curr)
	{
		super.addCurrency(curr, 0);
	}
	
	public Currency pop()
	{
		return super.removeCurrency(0);
	}
	
	public Currency peek()
	{
		return super.getCurrency(0);
	}
	
	public String printStack()
	{
		return super.printList();
	}
	
	public void destroyStack() // optional
	{
		
	}
}
