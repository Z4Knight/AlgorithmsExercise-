package exercise_search_hash_table;

import edu.princeton.cs.algs4.SequentialSearchST;
/**
 * 散列表，基于拉链法解决散列冲突
 * @author Z4Knight
 *
 * @param <Key> 插入键
 * @param <Value> 插入键对应的值
 */
public class SeparateChainingHashST<Key, Value> {
	// 键值对总数
	private int n;
	// 散列表大小
	private int m;
	// 存放链表对象的数组
	private SequentialSearchST<Key, Value>[] st;
	
	public SeparateChainingHashST() {
		this(997);
	}

	@SuppressWarnings("unchecked")
	public SeparateChainingHashST(int m) {
		// 创建 M 条链表
		this.m = m;
		st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
		for (int i = 0; i < m; i++) {
			st[i] = new SequentialSearchST<Key, Value>();
		}
	}
	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % m;
	}
	
	public Value get(Key key) {
		return (Value) st[hash(key)].get(key);
	}
	
	public void put(Key key, Value val) {
		st[hash(key)].put(key, val);
	}
}
