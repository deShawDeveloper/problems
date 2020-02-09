package linkedList;

public class LinkedList {
	
	private static LinkedListNode Head;
	private static int size;
	
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.addLast(1);
		linkedList.addLast(2);
		linkedList.addLast(3);
		linkedList.addLast(4);
		//linkedList.addFirst(4);
		//linkedList.remove(1);
		reverseLinkedList();
		printAllNodes();
		System.out.println("Size "+size);
	}
	
	public static void printAllNodes() {
		LinkedListNode current = Head; 
		while(current != null) {
				System.out.println(current.value);
			current = current.next;
		}
	}
	
	public static void reverseLinkedList() {
		LinkedListNode current = Head;
		LinkedListNode next = null;
		LinkedListNode previous = null;
		while (current != null) {
			next = current.next;
			if(next == null) {
				Head = current;
			}
			current.next = previous;
			previous = current;
			current =next;
			
		}
	}
	
	public boolean addLast(int value) {
		LinkedListNode node = new LinkedListNode(value);
		return addLast(node);
	}
	
	public boolean addFirst(int value) {
		LinkedListNode node = new LinkedListNode(value);
		return addFirst(node);
	}
	
	public boolean remove(int value) {
		LinkedListNode node = new LinkedListNode(value);
		return remove(node);
	}
	
	
	public boolean addFirst(LinkedListNode node) {
		if(Head == null) {
			Head = node;
			size++;
			return true;
		}else {
			node.next = Head;
			Head = node;
			size++;
			return true;
		}
	}
	
	public boolean remove(LinkedListNode node) {
		LinkedListNode current = Head;
		LinkedListNode previous = null;
		while (current != null) {
			if(current.equals(node)) {
				previous.next = current.next;
				size--;
				return true;
			}
			previous = current;
			current = current.next;
		}
		return false;
	}
	
	public boolean addLast(LinkedListNode node) {
		if(Head == null) {
			Head = node;
			size++;
			return true;
		}else {
			LinkedListNode current = Head;
			
			while(current != null) {
				if(current.next == null) {
					current.next = node;
					size++;
					return true;
				}
				current = current.next;
			}
		}
		return false;
	}
	
	public class LinkedListNode {

		public int value;
		public LinkedListNode next;
		
		LinkedListNode(int value){
			this.value = value;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + value;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			LinkedListNode other = (LinkedListNode) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (value != other.value)
				return false;
			return true;
		}

		private LinkedList getOuterType() {
			return LinkedList.this;
		}
		
		

	}

}



