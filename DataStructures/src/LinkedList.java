public class LinkedList<T extends Comparable<T>> {

	private Node<T> head;
	private Node<T> tail;
	private int length;

	public LinkedList() {
		head = null;
		tail = null;
		length = 0;
	}

	public void insertBegining(T data) {
		Node<T> node = new Node<T>(data);
		node.next = head;
		if(head == null) {
			tail = node;
		}
		head = node;
		length++;
	}

	public void insertEnd(T data) {
		Node<T> node = new Node<T>(data);
		tail.next = node;
		tail = tail.next;
		tail.next = null;
		length++;
	}

	public void removeHead() {
		head = head.next;
	}

	public int getLength() {
		
		if(head == null)
			return 0;
		Node<T> temp = head;
		
		int count =0;
		while(temp != null) {
			temp = temp.next;
			count++;
		}
		return count;
	}
	
	public void bubbleSort() {
		
		if(head == null || head.next == null)
			return;
				
		for(int i=0; i < length; i++) {
			Node<T> temp = head;
			Node<T> dummy = temp.next;
			while(dummy != null) {
				
				if(temp.data.compareTo(dummy.data) > 0) {
					T value = temp.data;
					temp.data = dummy.data;
					dummy.data = value;
				}
				dummy = dummy.next;
				temp = temp.next;
			}
		}
	}
	
	public Node<T> getMiddle(Node<T> head) {
		
		if (head == null)
			return head;
		
		Node<T> runner = head.next;
		Node<T> lagger = head;
		
		while(runner != null) {
			
			runner = runner.next;
			if(runner != null) {
				lagger = lagger.next;
				runner = runner.next;
			}
		}
		return lagger;
	}
	
	public Node<T> merge(Node<T> left, Node<T> right) {
		
		Node<T> done = null;
		
		if(left == null)
			return right;
		if(right == null)
			return left;
		
		if(left.data.compareTo(right.data) > 0) {
			done = right;
			done.next = merge(left,right.next);
		} else {
			done = left;
			done.next = merge(left.next,right);
		}
		return done;
	}
	
	public Node<T> mergeSort(Node<T> head) {
		
		if(head == null || head.next == null)
			return head;
		
		Node<T> mid = getMiddle(head);
		Node<T>midPlusOne = mid.next;
		mid.next = null;
		Node<T> left = mergeSort(head);
		Node<T> right = mergeSort(midPlusOne);
		Node<T> sortedList = merge(left,right);
		return sortedList;
	}

	public void mergeSort() {
		
		Node<T> temp = head;
		head = mergeSort(temp);
	}
	
	public void display() {

		Node<T> temp = head;
		while(temp != null) {
			System.out.print(temp.toString()+ " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public boolean isEmpty() {
		if(head == null)
			return true;
		else return false;
	}
}
