package exercise_sort_quick;


import edu.princeton.cs.algs4.StdRandom;
import exercise_sort_impl.Sort;
/**
 * 快速排序，初级实现
 * @author Z4Knight
 *
 */

public class Quick implements Sort{

	@Override
	public void sort(int[] array) {
		// 消除对输入的依赖
		StdRandom.shuffle(array);
		sort(array, 0, array.length- 1);
	}
	
	private void sort(int[] a, int lo, int hi) {
		if (hi <= lo) {
			return;
		}
		// 切分
		int j = partition(a, lo, hi);
		// 将左半部分 a[lo...j-1] 排序
		sort(a, lo, j-1);
		// 将右半部分 a[j+1...hi] 排序
		sort(a, j+1, hi);
	}

	private int partition(int[] a, int lo, int hi) {
		// 将数组切分为 a[lo...i] <= k <= a[j...hi]
		int i = lo;
		int j = hi+1;
		int k = a[lo];
		while (true) {
			// 扫描左右，检查是否结束并交换元素
			while (a[++i] < k) {
				if (i >= hi) {
					break;
				}
			}
			while (a[--j] > k) {
				// 因为 a[j] 最小是 k, 故此处判断条件可以省略
			}
			if (i >= j) {
				break;
			}
			exch(a, i, j);
		}
		// 将 k = a[j] 放入正确位置
		exch(a, lo, j);
		// a[lo...j-1] <= a[j] <= a[j+1...hi] 达成
		return j;
	}
	
	private void exch(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
}
