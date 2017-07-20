package exercise_sort_heap;

import exercise_sort_impl.Sort;

public class Heap implements Sort {

	// ��������ʹ�ö�����
	private void sink(int[] a, int k, int n) {
		while (2*k <= n) {
			// ��¼ k ���ӽڵ�
			int j = 2*k;
			// �ҳ��ӽڵ��и�����
			if (j < n && (a[j] < a[j+1])) {
				j++;
			}
			// k �������ӽڵ㶼����������
			if (!(a[k] < a[j])) {
				break;
			}
			// ���򽻻� k ���ӽڵ��λ��
			int t = a[k];
			a[k] = a[j];
			a[j] = t;
			k = j;
		}

	}

	
	private void exch(int[] a, int i, int k) {
		int t = a[i];
		a[i] = a[k];
		a[k] = t;
	}
	
	@Override
	public void sort(int[] a) {
		int n = a.length - 1;
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
