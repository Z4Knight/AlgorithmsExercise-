package exercise_sort_merge;

import exercise_sort_impl.Sort;

public class Merge implements Sort{
	// �����鲢����Ķ�������
	private int[] aux;
	
	// ��������������鲢��ԭ����
	public void merge (int[] a, int lo, int mid, int hi) {
		// �� a[lo..mid] �� a[mid+1..hi] �鲢
		int i = lo;
		int j = mid + 1;
		
		// �� a[lo..hi] ���Ƶ� aux[lo..hi]
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		// �鲢�ص� a[lo..hi]
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				a[k] = aux[j++];
			} else if (j > hi) {
				a[k] = aux[i++];
			} else if (a[i] > a[j]) {
				a[k] = aux[j++];
			} else {
				a[k] = aux[i++];
			}
		}
	}
	@Override
	public void sort(int[] array) {
		// һ���Է���ռ����������
		aux = new int[array.length];
		sort(array, 0, array.length - 1);
	}
	
	public void sort(int[] a, int lo, int hi) {
		// ������ a[lo..hi] ����
		if (hi <= lo) {
			return;
		}
		int mid = lo + (hi - lo) / 2;
		// ����������
		sort(a, lo, mid);
		// ���Ұ������
		sort(a, mid + 1, hi);
		// ��Ϊ�������򣬲���Ҫ�鲢
		if (a[mid] < a[mid + 1]) {
			return;
		}
		// �鲢
		merge(a, lo, mid, hi);		
	}
}
