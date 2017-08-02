package exercise_search_hash_table;

import java.util.Iterator;

import edu.princeton.cs.algs4.Queue;

/**
 * ɢ�б���������̽�ⷨ���ɢ�г�ͻ
 * @author Z4Knight
 *
 * @param <Key> �����
 * @param <Value> �������Ӧ��ֵ
 */
public class LinearProbingHashST<Key, Value> {

	// ���ű��м�ֵ�Ե�����
	private int n;
	// ����̽���Ĵ�С
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
		// ���Ҽ�
		int i;
		for (i = hash(key); keys[i] != null; i = (i+1) % m) {
			// ���У�����¼���Ӧ��ֵ
			if (keys[i].equals(key)) {
				vals[i] = val;
				return;
			}
		}
		// δ�����Ҹ�λ��Ϊ�գ����ڸ�λ�ô洢��ֵ��
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
