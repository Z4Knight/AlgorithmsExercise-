package exercise_structure;

public class Stack<Item> {

	private Node first;
	private int n;
	private class Node {
		Item item;
		Node next;
	}
	public boolean isEmpty() {
//		return n == 0;
		return first == null;
	}
	public int size() {
		return n;
	}
	public void push(Item item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		n++;
	}
	public Item pop() {
		if (first == null) {
			throw new NullPointerException();
		}
		Item item = first.item;
		first = first.next;
		n--;
		return item;
	}
}
