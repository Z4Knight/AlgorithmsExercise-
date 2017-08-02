package exercise_search_hash_table;

import edu.princeton.cs.algs4.SequentialSearchST;
/**
 * ɢ�б��������������ɢ�г�ͻ
 * @author Z4Knight
 *
 * @param <Key> �����
 * @param <Value> �������Ӧ��ֵ
 */
public class SeparateChainingHashST<Key, Value> {
	// ��ֵ������
	private int n;
	// ɢ�б��С
	private int m;
	// ���������������
	private SequentialSearchST<Key, Value>[] st;
	
	public SeparateChainingHashST() {
		this(997);
	}

	@SuppressWarnings("unchecked")
	public SeparateChainingHashST(int m) {
		// ���� M ������
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
