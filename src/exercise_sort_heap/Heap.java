package exercise_sort_heap;

import exercise_sort_impl.Sort;
/**
 * 堆排序，采用下沉使得堆有序
 * @author Z4Knight
 *
 */
public class Heap implements Sort {

	// 从上至下使得堆有序
	private void sink(int[] a, int k, int n) {
		while (2*k <= n) {
			// 记录 k 的子节点
			int j = 2*k;
			// 找出子节点中更大者
			if (j < n && (a[j-1] < a[j])) {
				j++;
			}
			// k 比两个子节点都大，则不做处理
			if (!(a[k-1] < a[j-1])) {
				break;	
			}
			// 否则交换 k 和子节点的位置
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
