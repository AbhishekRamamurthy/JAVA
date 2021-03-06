import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T extends Comparable<T>> {

	private Node<T> head;
	
	BinaryTree() {
		head = null;
	}
	
	public Node<T> getHead() {
		return head;
	}
	
	public void insert(T data, Node<T> head) {
		if(data.compareTo(head.data) <= 0) {
			if(head.left != null) {
				insert(data,head.left);
			} else {
				head.left = new Node<T>(data);
			}
		} else {
			if(head.right != null) {
				insert(data,head.right);
			} else {
				head.right = new Node<T>(data);
			}
		}
	}
	
	public void insert(T data) {
		Node<T> temp = new Node<T>(data);
		if(head == null)
			head = temp;
		else {
			insert(data,head);
		}
	}
	
	public int getHeight(Node<T> head) {
		if(head == null)
			return 0;
		int left = getHeight(head.left);
		int right = getHeight(head.right);
		return left > right ? left+1:right+1;
	}
	
	public int getHeight() {
		return getHeight(head);
	}
	
	public Node<T> balanceTree(ArrayList<Node<T>> list, int start,int end) {
		
		if(start > end)
			return null;
		
		int mid = (start+end)/2;
		Node<T> temp = list.get(mid);
		temp.left = balanceTree(list,start,mid-1);
		temp.right = balanceTree(list,mid+1,end);
		return temp;
	}
	
	public void balanceTree() {
		ArrayList<Node<T>> list = new ArrayList<Node<T>>();
		inOrder(head,list);
		head = balanceTree(list,0,list.size()-1);
	}
	
	public void levelOrderDisplay() {
		Queue<Node<T>> queue = new LinkedList<>();
		queue.add(head);
		while(true) {
			
			if(queue.size() == 0)
				break;
			
			int len = queue.size();
			while(len > 0) {
				Node<T> temp = queue.poll();
				System.out.print(temp.data+ " ");
				if(temp.left != null)
					queue.add(temp.left);
				if(temp.right != null)
					queue.add(temp.right);
				len --;
			}
			System.out.println();
		}
	}
	
	public void inOrder(Node<T> head, ArrayList<Node<T>> list) {
		
		if(head == null)
			return;
		inOrder(head.left,list);
		list.add(head);
		inOrder(head.right,list);
	}
	
	public Node<T> leastCommonAncestor(Node<T> head, T x, T y) {
		
		if(head == null)
			return null;
		
		if(head.data.compareTo(x) == 0 || head.data.compareTo(y) == 0) 
			return head;
		
		Node<T> left = leastCommonAncestor(head.left,x,y);
		//System.out.println(left.data);
		Node<T> right = leastCommonAncestor(head.right,x,y);
		
		if(left != null && right != null)
			return head;
		
		return left != null ? left : right;
	}
	
	public void display(Node<T> head) {
		if(head == null)
			return;
		display(head.left);
		System.out.println(head.data);
		display(head.right);
	}
	
}
