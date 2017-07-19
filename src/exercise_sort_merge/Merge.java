package exercise_sort_merge;

import exercise_sort_impl.Sort;

public class Merge implements Sort{
	// 创建归并所需的额外数组
	private int[] aux;
	
	// 将两个有序数组归并回原数组
	public void merge (int[] a, int lo, int mid, int hi) {
		// 将 a[lo..mid] 和 a[mid+1..hi] 归并
		int i = lo;
		int j = mid + 1;
		
		// 将 a[lo..hi] 复制到 aux[lo..hi]
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		// 归并回到 a[lo..hi]
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
		// 一次性分配空间给辅助数组
		aux = new int[array.length];
		sort(array, 0, array.length - 1);
	}
	
	public void sort(int[] a, int lo, int hi) {
		// 将数组 a[lo..hi] 排序
		if (hi <= lo) {
			return;
		}
		int mid = lo + (hi - lo) / 2;
		// 将左半边排序
		sort(a, lo, mid);
		// 将右半边排序
		sort(a, mid + 1, hi);
		// 认为数组有序，不需要归并
		if (a[mid] < a[mid + 1]) {
			return;
		}
		// 归并
		merge(a, lo, mid, hi);		
	}
}
