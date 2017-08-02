package exercise_sort_quick;


import edu.princeton.cs.algs4.StdRandom;
import exercise_sort_impl.Sort;
/**
 * �������򣬳���ʵ��
 * @author Z4Knight
 *
 */

public class Quick implements Sort{

	@Override
	public void sort(int[] array) {
		// ���������������
		StdRandom.shuffle(array);
		sort(array, 0, array.length- 1);
	}
	
	private void sort(int[] a, int lo, int hi) {
		if (hi <= lo) {
			return;
		}
		// �з�
		int j = partition(a, lo, hi);
		// ����벿�� a[lo...j-1] ����
		sort(a, lo, j-1);
		// ���Ұ벿�� a[j+1...hi] ����
		sort(a, j+1, hi);
	}

	private int partition(int[] a, int lo, int hi) {
		// �������з�Ϊ a[lo...i] <= k <= a[j...hi]
		int i = lo;
		int j = hi+1;
		int k = a[lo];
		while (true) {
			// ɨ�����ң�����Ƿ����������Ԫ��
			while (a[++i] < k) {
				if (i >= hi) {
					break;
				}
			}
			while (a[--j] > k) {
				// ��Ϊ a[j] ��С�� k, �ʴ˴��ж���������ʡ��
			}
			if (i >= j) {
				break;
			}
			exch(a, i, j);
		}
		// �� k = a[j] ������ȷλ��
		exch(a, lo, j);
		// a[lo...j-1] <= a[j] <= a[j+1...hi] ���
		return j;
	}
	
	private void exch(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
}
