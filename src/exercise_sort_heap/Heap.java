package exercise_sort_heap;

import exercise_sort_impl.Sort;

public class Heap implements Sort {

	// 从上至下使得堆有序
	private void sink(int[] a, int k, int n) {
		while (2*k <= n) {
			// 记录 k 的子节点
			int j = 2*k;
			// 找出子节点中更大者
			if (j < n && (a[j] < a[j+1])) {
				j++;
			}
			// k 比两个子节点都大，则不做处理
			if (!(a[k] < a[j])) {
				break;
			}
			// 否则交换 k 和子节点的位置
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
		// 构建堆有序
		for (int k = n/2; k >= 1; k--) {
			sink(a, k, n);
		}
		// 通过堆有序和下沉算法使得数组有序
		while (n > 1) {
			// 交换
			exch(a, 1, n--);
			// 维持堆有序
			sink(a, 1, n);
		}
	}
}
