package lab03;

public class Lab3Main 
{

	public static void main(String[] args) 
	{
		SinglyLinkedList list = new SinglyLinkedList();
		
		Currency curr1 = new Dollar(20.02);
		
		list.addCurrency(new Dollar(57.12), 0);
		list.addCurrency(curr1, 1);
		list.addCurrency(new Dollar(35.60), 2);
		System.out.println(list.printList() + list.getCount());
		System.out.println(list.findCurrency(curr1));
		list.removeCurrency(curr1);
		
		System.out.println(list.printList());
		
		
		Stack st = new Stack();
		st.push(new Dollar(20.02));
		st.push(new Dollar(40.02));
		st.push(new Dollar(60.02));
		
		System.out.println(st.printStack());
		
		
		/*
		// TODO Auto-generated method stub
		Currency currencies[] = new Dollar[20];
		currencies[0] = new Dollar(57.12);
		currencies[1] = new Dollar(57.12);
		currencies[2] = new Dollar(57.12);
		currencies[3] = new Dollar(57.12);
		currencies[4] = new Dollar(57.12);
		*/
	}

}
