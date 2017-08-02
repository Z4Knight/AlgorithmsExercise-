package exercise_search_hash_table;

import java.util.Iterator;

import edu.princeton.cs.algs4.Queue;

/**
 * 散列表，基于线性探测法解决散列冲突
 * @author Z4Knight
 *
 * @param <Key> 插入键
 * @param <Value> 插入键对应的值
 */
public class LinearProbingHashST<Key, Value> {

	// 符号表中键值对的总数
	private int n;
	// 线性探测表的大小
	private int m = 16;
	
	private Key[] keys;
	private Value[] vals;
	
	
	@SuppressWarnings("unchecked")
	public LinearProbingHashST(int cap) {
		m = cap;
		keys = (Key[]) new Object[m];
		vals = (Value[]) new Object[m];
	}
	
	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % m;
	}
	
	private void resize(int cap) {
		LinearProbingHashST<Key, Value> t;
		t = new LinearProbingHashST<>(cap);
		for (int i = 0; i < m; i++) {
			if (keys[i] != null) {
				t.put(keys[i], vals[i]);
			}
			keys = t.keys;
			vals = t.vals;
			m = t.m;
		}
	}
	
	public void put(Key key, Value val) {
		if (n >= m) {
			resize(2*m);
		}
		// 查找键
		int i;
		for (i = hash(key); keys[i] != null; i = (i+1) % m) {
			// 命中，则更新键对应的值
			if (keys[i].equals(key)) {
				vals[i] = val;
				return;
			}
		}
		// 未命中且该位置为空，则在该位置存储键值对
		keys[i] = key;
		vals[i] = val;
		n++;
	}
	
	public Value get(Key key) {
		for (int i = hash(key); keys[i] != null; i = (i+1) % m) {
			if (keys[i].equals(key)) {
				return vals[i];
			}
		}
		return null;
	}
	
	public Iterable<Key> keys() {
		Queue<Key> q = new Queue<Key>();
		if (keys == null) {
			return null;
		}
		for (int i = 0; i < keys.length; i++) {
			q.enqueue(keys[i]);
		}
		return q;
		
	}
	
	public boolean contains(Key key) {
		if (key != null) {
			Iterator<Key> it = keys().iterator();
			while (it.hasNext()) {
				if (key.equals((Key) it.next())) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void delete(Key key) {
		if (!contains(key)) {
			return;
		}
		int i = hash(key);
		while (!key.equals(keys[i])) {
			i = (i + 1) % m;
		}
		keys[i] = null;
		vals[i] = null;
		i = (i + 1) % m;
		while (keys[i] != null) {
			Key keyToRedo = keys[i];
			Value valToRedo = vals[i];
			keys[i] = null;
			vals[i] = null;
			n--;
			put(keyToRedo, valToRedo);
			i = (i + 1) % m;
		}
		n--;
		if (n > 0 && n == m/8) {
			resize(m/2);
		}
	}
}
