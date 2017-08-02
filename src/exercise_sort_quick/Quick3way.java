package exercise_sort_quick;

import edu.princeton.cs.algs4.StdRandom;
import exercise_sort_impl.Sort;

/**
 * ��������
 * �����з�ʵ��
 * @author Z4Knight
 *
 */
public class Quick3way implements Sort{

	@Override
	public void sort(int[] array) {
		// ���������������
		StdRandom.shuffle(array);
		sort(array, 0, array.length - 1);
	}
	
	private void sort(int[] a, int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		// ʹ�� a[lo..lt-1] < v, a[lt...gt] = v, v < a[gt+1..hi]
		int lt = lo, gt = hi, i = lo + 1;
		int v = a[lo];
		while (i <= gt) {
			if (v > a[i]) {
				exch(a, lt++, i++);
			} else if (v < a[i]) {
				exch(a, i, gt--);
			} else {
				i++;
			}
		}
		// ����벿�� a[lo..lt-1] ����
		sort(a, lo, lt - 1);
		// ���Ұ벿�� a[gt+1..hi] ����
		sort(a, gt + 1, hi);
		
	}
	
	private void exch(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
}
