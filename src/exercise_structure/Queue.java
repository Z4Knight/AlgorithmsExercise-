package exercise_structure;

public class Queue<Item> {

	private Node first;
	private Node last;
	private int n;
	private class Node {
		Item item;
		Node next;
	}
	public boolean isEmpty() {
		return n == 0;
	}
	public int size() {
		return n;
	}
	public void enqueue(Item item) {
		Node oldFirst = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) {
			first = last;
		} else {
			oldFirst.next = last;
		}
		n++;
	}
	public Item dequeue() {
		if (first == null) {
			throw new NullPointerException();
		}
		Item item = first.item;
		first = first.next;
		if (isEmpty()) {
			last = null;
		}
		n--;
		return item;
	}
}
