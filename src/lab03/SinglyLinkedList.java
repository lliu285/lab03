package lab03;

public class SinglyLinkedList 
{
	private int count; // is count the total number of nodes??
	private LinkNode start;
	private LinkNode end;
	
	public SinglyLinkedList()
	{
		count = 0;
		start = null;
		end = null;
	}
	
	public int getCount()
	{
		return count;
	}
	
	public LinkNode getStart()
	{
		return start;
	}
	
	public LinkNode getEnd()
	{
		return end;
	}
	
	public int createList() // change return type later
	{
		return 0; 
	}
	
	public void destroyList() // change return type later
	{
		
	}
	
	/*
	 * addCurrency method which takes a Currency object 
	 * and a node index value as parameters to add the Currency to the list at that index.
	 */
	public void addCurrency(Currency curr, int i)
	{
		LinkNode newNode = new LinkNode(curr, null);
		
		if (start == null) { // Insert as list's first node
			start = newNode;
			end = newNode;
		} else if (start != null && i == count) { // Insert after list's tail node
			end.setNext(newNode);
			end = newNode; 
		} else { // Insert in middle of list
			
			// use getCurrency() method or write another method?? this code's kinda redundant
			
			LinkNode currNode = start;
			
			for (int j = 0; j < i; j++) {
				currNode = currNode.getNext();
			}
			
			newNode.setNext(currNode.getNext());
			currNode.setNext(newNode);
		}
		
		count++;
	}
	
	/*
	 * removeCurrency method which takes a Currency object as parameter 
	 * and removes that Currency object from the list and may return a copy of the Currency.
	 */
	public Currency removeCurrency(Currency curr)
	{
		// any preconditions?? like if the list was empty or smth
		
		LinkNode prevNode = start;
		LinkNode nextNode = start.getNext();
		
		while (!prevNode.getNext().getData().isEqual(curr)) {
			prevNode = prevNode.getNext();
			nextNode = nextNode.getNext();
		}
		
		prevNode.setNext(nextNode.getNext());
		count--;

		return curr;
	}
	
	/*
	 * removeCurrency overload method which takes a node index as parameter 
	 * and removes the Currency object at that index and may return a copy of the Currency
	 */
	public Currency removeCurrency(int i)
	{
		// any preconditions?? like if the list was empty or smth
		
		LinkNode prevNode = start;
		LinkNode nextNode = start.getNext();
		
		for (int j = 0; j < i-1; j++) {
			prevNode = prevNode.getNext();
			nextNode = nextNode.getNext();
		}

		Currency curr = prevNode.getNext().getData();
		prevNode.setNext(nextNode.getNext());
		count--;

		return curr;
	}
	
	/*
	 * findCurrency method which takes a Currency object as parameter 
	 * and returns the node index at which the Currency is found in the list.
	 */
	public int findCurrency(Currency curr)
	{
		int i = 0;
		LinkNode currNode = start;
		
		while (!currNode.getData().isEqual(curr)) {
			currNode.setNext(currNode.getNext());
			i++;
		}
		
		return i;
	}
	
	public Currency getCurrency(int i)
	{
		LinkNode currNode = start;

		for (int j = 0; j < i; j++) {
			currNode = currNode.getNext();
		}
		
		return currNode.getData();
	}
	
	public String printList()
	{
		String nodeList = "";
		LinkNode currNode = start;
		
		for (int i = 0; i < count; i++) {
			nodeList += currNode.getData().toString() + "\t";
			currNode = currNode.getNext();
		}
		
		return nodeList;
	}
	
	public boolean isListEmpty()
	{
		return start == null;
	}
	
	public int countCurrency()
	{
		return count;
	}
}
