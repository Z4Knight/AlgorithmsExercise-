package exercise_search_red_black_BST;
/**
 * �������ֻʵ���˲������
 * @author Z4Knight
 *
 * @param <Key> �����
 * @param <Value> �������Ӧ��ֵ
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {

	// ����ɫֵ��Ϊ����
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	private Node root;
	
	private class Node {  
		// ��
		Key key;
		// �������ֵ
		Value val;
		// ��������
		Node left, right;
		// ��������ֵĽ������
		int n;
		// �ɸ��ڵ�ָ���������ӵ���ɫ
		boolean color;
		
		Node(Key key, Value val, int n, boolean color) {
			this.key = key;
			this.val = val;
			this.n = n;
			this.color = color;
		}
	}
	
	private boolean isRed(Node x) {
		if (x == null) {
			return false;
		}
		return x.color == RED;
	}
	
	public int size() {
		return size(root);
	}
	
	private int size(Node h) {
		if (h == null) {
			return 0;
		}
		return h.n;
	}
	
	// ��������һ����ɫ��������תΪ��ɫ������
	private Node rotateLeft(Node h) {
		// ָ�� h ��������
		Node x = h.right;
		// �� h ����������ָ������������������
		h.right = x.left;
		// �� h ��ԭ������ָ�� h
		x.left = h;
		// �� h �ĸ��ڵ�ָ������ԭ������
		x.color = h.color;
		x.n = h.n;
		// �޸� h ����ɫΪ��ɫ�����Ҹ��ڵ��Ϊ����ԭ������
		h.color = RED;
		h.n = size(h.right) + size(h.left)
				+ 1;
		return x;
	}
	// ����ͬ������ֻ�Ƿ����෴
	private Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		x.n = h.n;
		h.color = RED;
		h.n = size(h.right) + size(h.left)
				+ 1;
		return x;
	}
	// �任 h ���������������ɫ
	private void flipColors(Node h) {
		h.right.color = BLACK;
		h.left.color = BLACK;
		h.color = RED;
	}
	
	public void put(Key key, Value val) {
		// ���� key ���ҵ��������ֵ�������½����
		root = put(root, key, val);
		// ���ڵ���ɫ��Ϊ��ɫ
		root.color = BLACK;
	}
	
	private Node put(Node h, Key key, Value val) {
		// ��׼�Ĳ���������͸��ڵ��ú���������
		if (h == null) {
			return new Node(key, val, 1, RED);
		}
		// ���ҹ���
		int cmp = key.compareTo(h.key);
		// �ȸ��ļ�ֵС���Ͳ���������
		if (cmp < 0) {
			h.left = put(h.left, key, val);
		} else if (cmp > 0) {
		// �ȸ��ļ�ֵ�󣬾Ͳ���������
			h.right = put(h.right, key, val);
		} else {
		// �������¶�Ӧ��ֵ
			h.val = val;
		}
		// ��֤�������ƽ����
		// ���ֺ�ɫ�����ӣ�ͨ��������֤����ƽ��
		if (isRed(h.right) && !isRed(h.left)) {
			h = rotateLeft(h);
		}
		// ����������ɫ�����ӣ�ͨ��������֤����ƽ��
		if (isRed(h.left) && isRed(h.left.left)) {
			h = rotateRight(h);
		}
		// �������Һ�ɫ���ӣ�ͨ����ɫ�任��֤����ƽ��
		if (isRed(h.left) && isRed(h.right)) {
			flipColors(h);
		}
		// ������1
		h.n = size(h.left) + size(h.right) + 1;
		return h;
	}
}
