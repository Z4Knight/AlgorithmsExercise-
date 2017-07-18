package exercise_sort_selection;

import exercise_sort_impl.Sort;

/**
 * 选择排序（升序）
 * @author Z4Knight
 *
 */
public class Selection implements Sort {

	public  void sort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			// 负责交换最小值与排序后的数组的最后一位，同时向后遍历
			// 设当前索引为最小值索引
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				// 负责记录未排序数组中最小值的索引值
				if (a[min] > a[j]) {
					// 记录最小值索引
					min = j;
				}
			}
			// 交换
			int temp = a[min];
			a[min] = a[i];
			a[i] = temp;
		}
	}
}
