
public class Test {

	public static void main(String[] args) {

		LinkedList<Integer> obj = new LinkedList<Integer>();
		obj.insertBegining(1);
		obj.insertBegining(2);
		obj.insertBegining(3);
		obj.insertEnd(4);
		obj.insertEnd(5);
		System.out.print("Linked List Before Sort = ");
		obj.display();
		System.out.print("Linked List After Sort = ");
		obj.mergeSort();
		obj.display();
		//obj.bubbleSort();
		System.out.println("**************************************************");
		BinaryTree<Integer> objB = new BinaryTree<Integer>();
		objB.insert(5);
		objB.insert(4);
		objB.insert(3);
		objB.insert(2);
		objB.insert(1);
		Node<Integer> head = objB.getHead();
		System.out.println("Height Before Balance = " +objB.getHeight());
		System.out.println("Tree Before Balance Display");
		objB.display(head);
		objB.balanceTree();
		System.out.println("Height After Balance = "+objB.getHeight());
		head = objB.getHead();
		System.out.println("Tree After Balance Display");
		objB.levelOrderDisplay();
		head = objB.getHead();
		head = objB.leastCommonAncestor(head, 2, 4);
		System.out.println("Common Ancestor = "+ head.data);
	}
}
