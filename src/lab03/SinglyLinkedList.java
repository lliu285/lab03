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
	
	
	public int createList() // change return type later, not rly sure what it does
	{
		return 0; 
	}
	
	public void destroyList() // change return type later, not rly sure what it does
	{
		
	}
	
	/*
	 * 
	 */
	public int getCount()
	{
		return count;
	}
	
	/*
	 * 
	 */
	public LinkNode getStart()
	{
		return start;
	}
	
	/*
	 * 
	 */
	public LinkNode getEnd()
	{
		return end;
	}
	
	/*
	 * Preconditions:
	 * curr - Cannot be null
	 * i - Cannot be negative
	 * 
	 * addCurrency method which takes a Currency object 
	 * and a node index value as parameters to add the Currency to the list at that index.
	 */
	public void addCurrency(Currency curr, int i)
	{
		LinkNode newNode = new LinkNode(curr, null);
		
		if (start == null) { // Insert as list's first node
			start = newNode;
			end = newNode;
		} else if (i+1 > count) { // Insert after list's tail node
			end.setNext(newNode);
			end = newNode; 
		} else { // Insert in middle of list
			
			// use getCurrency() method or write another method?? this code's kinda redundant
			
			LinkNode currNode = start;
			
			for (int j = 0; j < i; j++) {
				currNode = currNode.getNext();
			}
			
			newNode.setNext(currNode.getNext()); // have to fix this
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
		if (curr == null || start == null) { // if curr or list is empty
			return null;
		} else if (start.getData() == curr) { // if curr is at start of the list
		    start = start.getNext();
		    count--;
		    if (count == 0) { // if there's only one node
		        end = null;
		    }
		    return curr;
		} else {
			LinkNode prevNode = start;
			LinkNode nextNode = prevNode.getNext();
			
		    while (nextNode != null) {
		        if (nextNode.getData() == curr) {      	
		            prevNode.setNext(nextNode.getNext());
		            count--;
		            if (nextNode == end) { // if removing last node
		                end = prevNode;
		            }

		            return curr;
		        } else {
		            prevNode = nextNode;
		            nextNode = prevNode.getNext();
		        }
		    }
		    return null;
		}
	}
	
	/*
	 * removeCurrency overload method which takes a node index as parameter 
	 * and removes the Currency object at that index and may return a copy of the Currency
	 */
	public Currency removeCurrency(int i)
	{
		if (i < 0 || i >= count || start == null) { // if curr list is empty
			return null;
		} else if (i == 0) { // if removing first node
			Currency startCurr = start.getData();
			start = start.getNext();
			count--;
			if (count == 0) { // if there's only one node
	        	end = null;
	    	}
			return startCurr;
		} else { // remove from middle or end of list
			
			// better way to implement remove from middle?
			// have to add case if it's ending tail node
			
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
	}
	
	/*
	 * findCurrency method which takes a Currency object as parameter 
	 * and returns the node index at which the Currency is found in the
     * list and returns -1 if not found.
	 * 
	 */
	public int findCurrency(Currency curr)
	{
		int i = 0;
		LinkNode currNode = start;
		
		if (curr == null) {
			return -1;
		}
		
		while (currNode != null) { // reference or actual value??
			if (currNode.getData() == curr) {
				return i;
			}
			
			currNode = currNode.getNext();
			i++;
		}
		
		return -1;
	}
	
	public Currency getCurrency(int i)
	{
		if (i < 0 || i >= count) {
			return null;
		}
		
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
