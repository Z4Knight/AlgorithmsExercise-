package exercise_sort_bubble;

import exercise_sort_impl.Sort;
/**
 * 冒泡排序
 * @author Z4Knight
 *
 */

public class Bubble implements Sort{

	@Override
	public void sort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			// 负责向后遍历数组
			for (int j = 0; j < array.length - i - 1; j++) {
				// 排序 a[j] 到 a[array,length - i - 1]的顺序
				// 每次比较前后两个数，前一个数比后一个数大，就往后移动，最后位置为最大的数
				if (array[j] > array[j + 1]) {
					int t = array[j];
					array[j] = array[j + 1];
					array[j + 1] = t;
				}
			}
		}
		
	}
}
