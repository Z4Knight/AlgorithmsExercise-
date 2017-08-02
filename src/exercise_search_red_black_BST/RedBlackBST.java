package exercise_search_red_black_BST;
/**
 * 红黑树，只实现了插入操作
 * @author Z4Knight
 *
 * @param <Key> 插入键
 * @param <Value> 插入键对应的值
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {

	// 将颜色值设为常量
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	private Node root;
	
	private class Node {  
		// 键
		Key key;
		// 相关联的值
		Value val;
		// 左右子树
		Node left, right;
		// 这棵子树种的结点总数
		int n;
		// 由父节点指向它的链接的颜色
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
	
	// 左旋，将一条红色右链接旋转为红色左链接
	private Node rotateLeft(Node h) {
		// 指向 h 的右链接
		Node x = h.right;
		// 将 h 右子树重新指向它右子树的左子树
		h.right = x.left;
		// 将 h 的原右子树指向 h
		x.left = h;
		// 将 h 的父节点指向它的原右子树
		x.color = h.color;
		x.n = h.n;
		// 修改 h 的颜色为红色，并且父节点改为它的原右子树
		h.color = RED;
		h.n = size(h.right) + size(h.left)
				+ 1;
		return x;
	}
	// 右旋同左旋，只是方向相反
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
	// 变换 h 结点左右子树的颜色
	private void flipColors(Node h) {
		h.right.color = BLACK;
		h.left.color = BLACK;
		h.color = RED;
	}
	
	public void put(Key key, Value val) {
		// 查找 key ，找到则更新其值，否则新建结点
		root = put(root, key, val);
		// 根节点颜色总为黑色
		root.color = BLACK;
	}
	
	private Node put(Node h, Key key, Value val) {
		// 标准的插入操作，和父节点用红链接连接
		if (h == null) {
			return new Node(key, val, 1, RED);
		}
		// 查找过程
		int cmp = key.compareTo(h.key);
		// 比根的键值小，就插入左子树
		if (cmp < 0) {
			h.left = put(h.left, key, val);
		} else if (cmp > 0) {
		// 比根的键值大，就插入右子树
			h.right = put(h.right, key, val);
		} else {
		// 相等则更新对应的值
			h.val = val;
		}
		// 保证红黑树的平衡性
		// 出现红色右链接，通过左旋保证树的平衡
		if (isRed(h.right) && !isRed(h.left)) {
			h = rotateLeft(h);
		}
		// 出现连续红色左链接，通过右旋保证树的平衡
		if (isRed(h.left) && isRed(h.left.left)) {
			h = rotateRight(h);
		}
		// 出现左右红色链接，通过颜色变换保证树的平衡
		if (isRed(h.left) && isRed(h.right)) {
			flipColors(h);
		}
		// 个数加1
		h.n = size(h.left) + size(h.right) + 1;
		return h;
	}
}
