package exercise_sort_heap;

import exercise_sort_impl.Sort;
/**
 * �����򣬲����³�ʹ�ö�����
 * @author Z4Knight
 *
 */
public class Heap implements Sort {

	// ��������ʹ�ö�����
	private void sink(int[] a, int k, int n) {
		while (2*k <= n) {
			// ��¼ k ���ӽڵ�
			int j = 2*k;
			// �ҳ��ӽڵ��и�����
			if (j < n && (a[j-1] < a[j])) {
				j++;
			}
			// k �������ӽڵ㶼����������
			if (!(a[k-1] < a[j-1])) {
				break;	
			}
			// ���򽻻� k ���ӽڵ��λ��
			exch(a, j, k);
			k = j;
		}

	}

	
	private void exch(int[] a, int i, int k) {
		int t = a[i-1];
		a[i-1] = a[k-1];
		a[k-1] = t;
	}
	
	@Override
	public void sort(int[] a) {
		int n = a.length;
		// ����������
		for (int k = n/2; k >= 1; k--) {
			sink(a, k, n);
		}
		// ͨ����������³��㷨ʹ����������
		while (n > 1) {
			// ����
			exch(a, 1, n--);
			// ά�ֶ�����
			sink(a, 1, n);
		}
	}
}
